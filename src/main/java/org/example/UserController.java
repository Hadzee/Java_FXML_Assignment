package org.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField address;
    @FXML
    private ChoiceBox<String> cbSpeed;
    @FXML
    private ChoiceBox<String> cbBandwidth;
    @FXML
    private ChoiceBox<String> cbDuration;
    @FXML
    private Button saveButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button closeButton;
    @FXML
    private Button deleteButton;

    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;

    ObservableList<User> people = FXCollections.<User>observableArrayList();
    User person;

    @FXML
    TableView<User> table = new TableView<>();

    public UserController() {
    }

    @FXML
    private void initialize() {
        person = new User();

        firstName.textProperty().bindBidirectional(person.firstNameProperty());
        lastName.textProperty().bindBidirectional(person.lastNameProperty());
        address.textProperty().bindBidirectional(person.addressProperty());
        cbSpeed.valueProperty().bindBidirectional(person.speedProperty());
        cbBandwidth.valueProperty().bindBidirectional(person.bandwidthProperty());
        cbDuration.valueProperty().bindBidirectional(person.durationProperty());

        cbSpeed.getItems().addAll("2", "5", "10", "20", "50", "100");
        cbBandwidth.getItems().addAll("1", "5", "10", "100", "Flat");
        cbDuration.getItems().addAll("1 year", "2 years");
    }

    @FXML
    private void savePerson() {

        people = table.getItems();
        people.add(new User(firstName.getText(), lastName.getText(), address.getText(),
                cbSpeed.getSelectionModel().getSelectedItem(),
                cbBandwidth.getSelectionModel().getSelectedItem(),
                cbDuration.getSelectionModel().getSelectedItem()));

        table.setItems(people);

    }

    @FXML
    private void clearPerson() {

        person.firstNameProperty().set("");
        person.lastNameProperty().set("");
        person.addressProperty().set("");
        person.speedProperty().set("");
        person.bandwidthProperty().set("");
        person.durationProperty().set("");

    }


    @FXML
    private void deletePerson() {

        people = table.getItems();
        int index = table.selectionModelProperty().getValue().getSelectedIndex();
        if (index != -1) {

            people.remove(index);
            table.setItems(people);

        } else {

            StringBuilder errMsg = new StringBuilder();

            ArrayList<String> errList = person.errorsProperty().get();
            for (String errList1 : errList)
                errMsg.append(errList1);

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Select a person first, then click on 'Delete'.");
            alert.setContentText(errMsg.toString());
            alert.showAndWait();
            errList.clear();

        }

    }

}