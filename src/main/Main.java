package main;

import controller.ConfigurationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.App;
import routes.Routes;

public class Main extends Application {

    public static App app;
    public static ConfigurationController controller;

    public static void main(String[] args) {
        app = new App();
        controller = new ConfigurationController(app);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/configurationView.fxml"));
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();        
    }
}
