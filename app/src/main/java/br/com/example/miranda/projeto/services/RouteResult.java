package br.com.example.miranda.projeto.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RouteResult implements Serializable {

    private String routeId;
    private String nmRoute;
    private List<String> streetsWithinTheRoute;
    private List<String> timetable;

    public RouteResult(String routeId, String nmRoute) {
        this.routeId = routeId;
        this.nmRoute = nmRoute;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getNmRoute() {
        return nmRoute;
    }

    public void setNmRoute(String nmRoute) {
        this.nmRoute = nmRoute;
    }

    public List<String> getStreetsWithinTheRoute() {
        if (this.streetsWithinTheRoute == null) {
            this.streetsWithinTheRoute = new ArrayList<String>();
        }
        return streetsWithinTheRoute;
    }

    public void setStreetsWithinTheRoute(List<String> streetsWithinTheRoute) {
        this.streetsWithinTheRoute = streetsWithinTheRoute;
    }

    public List<String> getTimetable() {
        if (this.timetable == null) {
            this.timetable = new ArrayList<>();
        }
        return timetable;
    }

    public void setTimetable(List<String> timetable) {
        this.timetable = timetable;
    }

}
