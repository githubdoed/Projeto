package br.com.example.miranda.projeto.services.pojos;

import java.util.ArrayList;
import java.util.List;

public class PojoRoute {

    private List<Route> routes;

    public PojoRoute(List<Route> routes) {
        this.routes = routes;
    }

    public List<Route> getRoutes() {
        if (this.routes == null) {
            this.routes = new ArrayList<Route>();
        }
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

}
