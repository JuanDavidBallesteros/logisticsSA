package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ResultController {

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

    @FXML
    void backBTN(ActionEvent event) {

    }

    @FXML
    void export(ActionEvent event) {

    }

}
