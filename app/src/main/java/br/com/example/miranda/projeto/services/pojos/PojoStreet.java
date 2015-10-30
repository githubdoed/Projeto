package br.com.example.miranda.projeto.services.pojos;

import java.util.ArrayList;
import java.util.List;

public class PojoStreet {

    private List<Street> streets;

    public PojoStreet(List<Street> streets) {
        this.streets = streets;
    }

    public List<Street> getStreets() {
        if (this.streets == null) {
            this.streets = new ArrayList<Street>();
        }
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

}
