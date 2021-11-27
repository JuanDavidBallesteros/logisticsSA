package controller;

import java.io.File;
import java.io.IOException;

import exception.GraphException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.App;

public class ConfigurationController {

    private App app;
    private MainGui generalController;

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
        this.generalController =  new MainGui(app);
    }

    @FXML
    void fileBTN(ActionEvent event) {
        try {
        FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose File");
            File file = fileChooser.showOpenDialog(mainPane.getScene().getWindow()); // stage.getScene().getWindow() - stage
            if (file != null) {
                    int num = app.importStores(file.getPath());
                    generalController.alert(AlertType.INFORMATION, "Datos importados", "Se importaron " + num + " datos");
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            
    }

    @FXML
    void fileConnectionsBTN(ActionEvent event) {
        try {
        FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose File");
            File file = fileChooser.showOpenDialog(mainPane.getScene().getWindow()); // stage.getScene().getWindow() - stage
            if (file != null) {
                int num = app.importConnections(file.getPath());
                generalController.alert(AlertType.INFORMATION, "Datos importados", "Se importaron " + num + " datos");

            }
        } catch (IOException | GraphException e) {
            e.printStackTrace();
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
