package br.com.example.miranda.projeto.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.example.miranda.projeto.services.pojos.Departure;
import br.com.example.miranda.projeto.services.pojos.PojoDeparture;

public class DepartureDeserializer implements JsonDeserializer<PojoDeparture> {
    @Override
    public PojoDeparture deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Map<String, List<Departure>> mapDeparture = new HashMap<String, List<Departure>>();
        JsonArray array = json.getAsJsonObject().getAsJsonArray("rows");
        for (JsonElement element : array) {
            Departure departure = new Departure();
            departure.setId(element.getAsJsonObject().get("id").getAsInt());
            departure.setCalendar(element.getAsJsonObject().get("calendar").getAsString());
            departure.setTime(element.getAsJsonObject().get("time").getAsString());

            String typeOfTheDay = departure.getCalendar();
            if (mapDeparture.containsKey(typeOfTheDay)) {
                mapDeparture.get(typeOfTheDay).add(departure);
            } else {
                mapDeparture.put(typeOfTheDay, new ArrayList<Departure>());
            }
        }
        return new PojoDeparture(mapDeparture);
    }
}
