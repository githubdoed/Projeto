package br.com.example.miranda.projeto.services.pojos;

import java.io.Serializable;

public class Street implements Serializable {

    private Integer id;
    private String name;
    private Integer sequence;
    private Integer route_id;

    public Street(Integer id, String name, Integer sequence, Integer route_id) {
        this.id = id;
        this.name = name;
        this.sequence = sequence;
        this.route_id = route_id;
    }

    public Street() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Integer route_id) {
        this.route_id = route_id;
    }
}
