package controller;

import java.io.IOException;
import java.util.Arrays;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import model.App;
import model.Car;
import model.Result;

public class ResultController {

    private App app;
    private Result result;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TableView<Car> smallStoresTV;

    @FXML
    private TableColumn<Car, Integer> costSS;

    @FXML
    private TableColumn<Car, String> ownerSS;

    @FXML
    private TableView<Car> mediumStoresTV;

    @FXML
    private TableColumn<Car, Integer> costMS;

    @FXML
    private TableColumn<Car, String> ownerMS;

    @FXML
    private TableView<Car> bigStoresTV;

    @FXML
    private TableColumn<Car, Integer> costBS;

    @FXML
    private TableColumn<Car, String> ownerBS;

    public ResultController(App app, Result result) {
        this.app = app;
        this.result = result;
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

    public void initializeTableView() {

        ObservableList<Car> observableList1 = FXCollections.observableArrayList(result.getListSmall());
        ObservableList<Car> observableList2 = FXCollections.observableArrayList(result.getListMedium());
        ObservableList<Car> observableList3 = FXCollections.observableArrayList(result.getListBig());

        costSS.setCellValueFactory(new PropertyValueFactory<Car, Integer>("cost"));
        ownerSS.setCellValueFactory(new Callback<CellDataFeatures<Car, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Car, String> data) {
                return new ReadOnlyStringWrapper(Arrays.toString(data.getValue().getDestinations().toArray()));
            }
        });

        costMS.setCellValueFactory(new PropertyValueFactory<Car, Integer>("cost"));
        ownerMS.setCellValueFactory(new Callback<CellDataFeatures<Car, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Car, String> data) {
                return new ReadOnlyStringWrapper(Arrays.toString(data.getValue().getDestinations().toArray()));
            }
        });

        costBS.setCellValueFactory(new PropertyValueFactory<Car, Integer>("cost"));
        ownerBS.setCellValueFactory(new Callback<CellDataFeatures<Car, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Car, String> data) {
                return new ReadOnlyStringWrapper(Arrays.toString(data.getValue().getDestinations().toArray()));
            }
        });

        smallStoresTV.setItems(observableList1);
        mediumStoresTV.setItems(observableList2);
        bigStoresTV.setItems(observableList3);

    }

    /*
     * bagCol.setCellValueFactory(new Callback<CellDataFeatures<Client, String>,
     * ObservableValue<String>>() {
     * 
     * @Override
     * public ObservableValue<String> call(CellDataFeatures<Client, String> data) {
     * return new ReadOnlyStringWrapper(data.getValue().getBag().toString());
     * }
     * });
     */

}
