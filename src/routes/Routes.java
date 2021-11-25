package routes;

public enum Routes {
    
    CONFIG_VIEW("../ui/configurationView.fxml"), RESULTS_VIEW("../ui/resultsView.fxml");

    private String route;

    private Routes(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
