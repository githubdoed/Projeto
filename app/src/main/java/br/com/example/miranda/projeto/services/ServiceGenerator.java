package br.com.example.miranda.projeto.services;

import android.util.Base64;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class ServiceGenerator {

    public static final String API_BASE_URL = "https://api.appglu.com/v1/queries";

    private static RestAdapter.Builder builder = new RestAdapter.Builder()
            .setEndpoint(API_BASE_URL)
            .setClient(new OkClient(new OkHttpClient()));

    public static <S> S createService(Class<S> serviceClass) {
            String username = "WKD4N7YMA1uiM8V";
            String password = "DtdTtzMLQlA0hk2C1Yi5pLyVIlAQ68";
            String credentials = username + ":" + password;
            final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Authorization", basic);
                    request.addHeader("X-AppGlu-Environment", "staging");
                }
            });

            builder.setLogLevel(RestAdapter.LogLevel.FULL).setLog(new RestAdapter.Log() {
                public void log(String msg) {
                    Log.i("Retrofit", msg);
                }
            });

        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }

}