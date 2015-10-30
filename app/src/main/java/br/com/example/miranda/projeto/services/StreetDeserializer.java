package br.com.example.miranda.projeto.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.example.miranda.projeto.services.pojos.PojoStreet;
import br.com.example.miranda.projeto.services.pojos.Street;

public class StreetDeserializer implements JsonDeserializer<PojoStreet> {
    @Override
    public PojoStreet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<Street> streets = new ArrayList<Street>();
        JsonArray array = json.getAsJsonObject().getAsJsonArray("rows");
        for (JsonElement element : array) {
            Street street = new Street();
            street.setId(element.getAsJsonObject().get("id").getAsInt());
            street.setName(element.getAsJsonObject().get("name").getAsString());
            streets.add(street);
        }
        return new PojoStreet(streets);
    }
}
