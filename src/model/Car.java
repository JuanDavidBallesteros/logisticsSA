package model;

import java.util.ArrayList;

public class Car {
    private int cost;
    private ArrayList<Store> destinations, route;

    public Car() {
        destinations = new ArrayList<>();
        route  = new ArrayList<>();
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ArrayList<Store> getDestinations() {
        return destinations;
    }

    public void setDestinations(ArrayList<Store> destinations) {
        this.destinations = destinations;
    }

    public ArrayList<Store> getRoute() {
        return route;
    }

    public void setRoute(ArrayList<Store> route) {
        this.route = route;
    }

    
}
