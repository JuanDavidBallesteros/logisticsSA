package controller;

import java.util.Arrays;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
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

    public ModalController(Car car, Stage stage){
        this.car = car;
        this.stage = stage;
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
}
