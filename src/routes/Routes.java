package routes;

public enum Routes {
    
    MAIN_VIEW("../ui/assets/main.fxml");

    private String route;

    private Routes(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
