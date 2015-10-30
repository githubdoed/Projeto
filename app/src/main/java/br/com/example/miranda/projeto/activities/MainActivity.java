package br.com.example.miranda.projeto.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.Serializable;
import java.util.List;

import br.com.example.miranda.projeto.R;
import br.com.example.miranda.projeto.adapters.RouteAdapter;
import br.com.example.miranda.projeto.services.pojos.Body;
import br.com.example.miranda.projeto.services.pojos.PojoRoute;
import br.com.example.miranda.projeto.services.pojos.Route;
import br.com.example.miranda.projeto.services.RouteDeserializer;
import br.com.example.miranda.projeto.services.RouteListener;
import br.com.example.miranda.projeto.services.ServiceGenerator;
import br.com.example.miranda.projeto.services.pojos.Params;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private EditText localizacao;
    private Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localizacao = (EditText) findViewById(R.id.editText);
        buscar = (Button) findViewById(R.id.button);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Body body = new Body(new Params("%" + localizacao.getText().toString() + "%", null));

                ServiceGenerator.createService(RouteListener.class).getRoutesByStopName(body, new Callback<JsonElement>() {
                    @Override
                    public void success(JsonElement jsonElement, Response response) {
                        Gson gson = new GsonBuilder().registerTypeAdapter(PojoRoute.class, new RouteDeserializer()).create();
                        final List<Route> routes = gson.fromJson(jsonElement, PojoRoute.class).getRoutes();
                        ListView listView = (ListView) findViewById(R.id.listView);
                        if (!routes.isEmpty()) {
                            RouteAdapter adapter = new RouteAdapter(MainActivity.this, routes);
                            listView.setAdapter(adapter);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                                    Route route = routes.get(position);
                                    Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable("route", (Serializable) route);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                }
                            });
                        } else {
                            listView.setAdapter(null);
                            Toast.makeText(getApplicationContext(), "Rotas não encontradas!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

}