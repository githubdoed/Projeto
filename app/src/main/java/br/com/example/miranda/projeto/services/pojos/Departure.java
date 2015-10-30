package br.com.example.miranda.projeto.services.pojos;

import java.io.Serializable;

public class Departure implements Serializable {

    private Integer id;
    private String calendar;
    private String time;

    public Departure(Integer id, String calendar, String time) {
        this.id = id;
        this.calendar = calendar;
        this.time = time;
    }

    public Departure() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
