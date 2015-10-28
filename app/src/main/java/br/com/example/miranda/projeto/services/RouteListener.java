package br.com.example.miranda.projeto.services;
import com.google.gson.JsonElement;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

public interface RouteListener {

    @POST("/findRoutesByStopName/run")
    void getRoutesByStopName(@Body Stop stop, Callback<JsonElement> response);

    @POST("/findStopsByRouteId/run")
    void getStopsByRouteId(@Body Route route, Callback<JsonElement> response);

    @POST("/findDeparturesByRouteId/run")
    void getDeparturesByRouteId(@Body Route route, Callback<JsonElement> response);

}
