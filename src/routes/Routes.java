package routes;

public enum Routes {
    
    CONFIG_VIEW("../ui/configurationView.fxml");

    private String route;

    private Routes(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
