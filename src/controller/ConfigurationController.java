package controller;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.App;

public class ConfigurationController {

    private App app;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TextField bigCarsTF;

    @FXML
    private TextField mediumCarsTF;

    @FXML
    private TextField smallCarsTF;

    public ConfigurationController(App app) {
        this.app = app;
    }

    @FXML
    void fileBTN(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose File");
            File file = fileChooser.showOpenDialog(mainPane.getScene().getWindow()); // stage.getScene().getWindow() - stage
            if (file != null) {
                System.out.println("HOLA");
            }
    }


    @FXML
    void calculateBTN(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/resultsView.fxml"));
            ResultController controller = new ResultController(app);
            fxmlLoader.setController(controller);
            Parent results = fxmlLoader.load();
            mainPane.getChildren().setAll(results);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
