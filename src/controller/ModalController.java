package controller;

import java.io.File;
import java.io.IOException;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.*;

public class ModalController {

    @FXML
    private TableView<Store> destinationsTV;

    @FXML
    private TableColumn<Store, String> storesDestinations;

    @FXML
    private TableView<Store> routeTV;

    @FXML
    private TableColumn<Store, String> storesRoute;

    @FXML
    private Label costoTF;

    private Car car;

    private Stage stage;

    @FXML
    void hideBTN(ActionEvent event) {
        stage.close();
    }

    private MainGui generalController;

    private App app;

    public ModalController(Car car, Stage stage, App app){
        this.car = car;
        this.stage = stage;
        generalController = new MainGui(app);
        this.app = app;
    }

    public void init(){
        costoTF.setText(car.getCost()+"");
        initializeTableView();
    }

    public void initializeTableView(){
        ObservableList<Store> observableList1 = FXCollections.observableArrayList(car.getDestinations());
        ObservableList<Store> observableList2 = FXCollections.observableArrayList(car.getRoute());


        storesDestinations.setCellValueFactory(new Callback<CellDataFeatures<Store, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Store, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().getId() + " " + data.getValue().getOwner());
            }
        });

        storesRoute.setCellValueFactory(new Callback<CellDataFeatures<Store, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Store, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().getId() + " " + data.getValue().getOwner());
            }
        });

        destinationsTV.setItems(observableList1);
        routeTV.setItems(observableList2);
    }

    @FXML
    void export(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showSaveDialog(costoTF.getScene().getWindow());

        if (file != null) {
            try {
                app.exportList(file, car.getRoute());

            } catch ( IOException e1 ) {

                generalController.alert(AlertType.ERROR, "ERROR", "Data save fail");
                e1.printStackTrace();
            }
        }
    }

}
