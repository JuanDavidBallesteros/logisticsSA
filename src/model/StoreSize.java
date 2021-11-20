package model;

public enum StoreSize {
    SMALL("Small"), MEDIUM("Medium"), BIG("Big");

    private String route;

    private StoreSize(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
