package br.com.example.miranda.projeto.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.example.miranda.projeto.services.pojos.PojoRoute;
import br.com.example.miranda.projeto.services.pojos.Route;

public class RouteDeserializer implements JsonDeserializer<PojoRoute> {
    @Override
    public PojoRoute deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<Route> routes = new ArrayList<Route>();
        JsonArray array = json.getAsJsonObject().getAsJsonArray("rows");
        for (JsonElement element : array) {
            Route route = new Route();
            route.setId(element.getAsJsonObject().get("id").getAsInt());
            route.setLongName(element.getAsJsonObject().get("longName").getAsString());
            routes.add(route);
        }
        return new PojoRoute(routes);
    }
}
