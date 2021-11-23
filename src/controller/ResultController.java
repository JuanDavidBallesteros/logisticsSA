package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.App;

public class ResultController {

    private App app;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableView<?> smallStoresTV;

    @FXML
    private TableColumn<?, ?> idSS;

    @FXML
    private TableColumn<?, ?> ownerSS;

    @FXML
    private TableColumn<?, ?> orderSS;

    @FXML
    private TableView<?> mediumStoresTV;

    @FXML
    private TableColumn<?, ?> idMS;

    @FXML
    private TableColumn<?, ?> ownerMS;

    @FXML
    private TableColumn<?, ?> orderMS;

    @FXML
    private TableView<?> bigStoresTV;

    @FXML
    private TableColumn<?, ?> idBS;

    @FXML
    private TableColumn<?, ?> ownerBS;

    @FXML
    private TableColumn<?, ?> orderBS;

    public ResultController(App app) {
        this.app = app;
    }

    @FXML
    void backBTN(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/configurationView.fxml"));
            ConfigurationController controller = new ConfigurationController(app);
            fxmlLoader.setController(controller);
            Parent results = fxmlLoader.load();
            mainPane.getChildren().setAll(results);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void export(ActionEvent event) {

    }

}
