package Flight.scanner.controllers;

import Flight.scanner.modelFX.AirlineFx;
import Flight.scanner.modelFX.AirlineModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class AirlineController {

    @FXML
    private Button addAirlineButton;

    @FXML
    private Button editAirlineButton;

    @FXML
    private Button deleteAirlineButton;

    @FXML
    private TextField airlineTextField;

    @FXML
    private ComboBox<AirlineFx> airlineCombobox;
    private AirlineModel airlineModel;

    @FXML
    public void initialize(){
        this.airlineModel = new AirlineModel();
        this.airlineModel.init();
        this.airlineCombobox.setItems(this.airlineModel.getAirlineList());
        initBindings();
    }

    private void initBindings() {
        this.addAirlineButton.disableProperty().bind(airlineTextField.textProperty().isEmpty());
        this.deleteAirlineButton.disableProperty().bind(this.airlineModel.airlineProperty().isNull());
    }

    public void addAirlineOnActon(ActionEvent actionEvent) {
        airlineModel.saveAirlineInDataBase(airlineTextField.getText());
        airlineTextField.clear();
    }

    public void deleteAirlineOnAction(ActionEvent actionEvent) {
        this.airlineModel.deleteAirlineById();
    }

    public void onActionComboBox(ActionEvent actionEvent) {
        this.airlineModel.setAirline(this.airlineCombobox.getSelectionModel().getSelectedItem());

    }

    public void editOnAction(ActionEvent actionEvent) {
    }
}
