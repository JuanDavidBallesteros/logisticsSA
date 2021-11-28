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
import model.Result;

public class ConfigurationController {

    private App app;
    private MainGui generalController;

    private boolean file1, file2;

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
        this.generalController = new MainGui(app);
        file1 = false;
        file2 = false;
    }

    @FXML
    void fileBTN(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose File");
            File file = fileChooser.showOpenDialog(mainPane.getScene().getWindow()); // stage.getScene().getWindow() -
                                                                                     // stage
            if (file != null) {
                int num = app.importStores(file.getPath());
                file1 = true;

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
            File file = fileChooser.showOpenDialog(mainPane.getScene().getWindow()); // stage.getScene().getWindow() -
                                                                                     // stage
            if (file != null) {
                int num = app.importConnections(file.getPath());
                file2 = true;
                generalController.alert(AlertType.INFORMATION, "Datos importados", "Se importaron " + num + " datos");

            }
        } catch (IOException | GraphException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe){
            generalController.alert(AlertType.ERROR, "Error en carga", "Estructura del archivo no compatible");
        }
    }

    @FXML
    void calculateBTN(ActionEvent event) {

        if (validation()) {
            try {
                app.setVariables(Integer.parseInt(smallCarsTF.getText()), Integer.parseInt(mediumCarsTF.getText()),
                        Integer.parseInt(bigCarsTF.getText()));
                        
                Result res = app.calculate();

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/resultsView.fxml"));
                    ResultController controller = new ResultController(app, res);
                    fxmlLoader.setController(controller);
                    Parent results = fxmlLoader.load();
                    mainPane.getChildren().setAll(results);
                    controller.initializeTableView();

                    
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (NumberFormatException e) {
                generalController.alert(AlertType.ERROR, "Error de caracter", "ingresa valores numéricos");
            }
        } else {
            generalController.alert(AlertType.WARNING, "No se puede calcular", "Llena los campos y carga los archivos");
        }

    }

    private boolean validation() {
        boolean status = true;
        if (smallCarsTF.getText().equals("") || mediumCarsTF.getText().equals("") ||
                bigCarsTF.getText().equals("") || !file1 || !file2) {
            status = false;
        }
        return status;
    }

}
