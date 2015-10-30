package br.com.example.miranda.projeto.services;
import com.google.gson.JsonElement;

import br.com.example.miranda.projeto.services.pojos.Body;
import retrofit.Callback;
import retrofit.http.POST;

public interface RouteListener {

    @POST("/findRoutesByStopName/run")
    void getRoutesByStopName(@retrofit.http.Body Body body, Callback<JsonElement> response);

    @POST("/findStopsByRouteId/run")
    void getStopsByRouteId(@retrofit.http.Body Body body, Callback<JsonElement> response);

    @POST("/findDeparturesByRouteId/run")
    void getDeparturesByRouteId(@retrofit.http.Body Body body, Callback<JsonElement> response);

}
