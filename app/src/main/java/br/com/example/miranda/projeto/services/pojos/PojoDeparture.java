package br.com.example.miranda.projeto.services.pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PojoDeparture {

    private Map<String, List<Departure>> mapDeparture;

    public PojoDeparture(Map<String, List<Departure>> mapDeparture) {
        this.mapDeparture = mapDeparture;
    }

    public Map<String, List<Departure>> getMapDeparture() {
        if (this.mapDeparture == null) {
            this.mapDeparture = new HashMap<String, List<Departure>>();
        }
        return mapDeparture;
    }

    public void setMapDeparture(Map<String, List<Departure>> mapDeparture) {
       this.mapDeparture = mapDeparture;
    }
}
