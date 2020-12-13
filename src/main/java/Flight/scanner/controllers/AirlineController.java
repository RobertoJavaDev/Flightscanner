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
    private TextField airlineTextField;

    @FXML
    private ComboBox<AirlineFx> airlineCombobox;
    private AirlineModel airlineModel;

    @FXML
    public void initialize(){
        this.airlineModel = new AirlineModel();
    }


    public void addAirlineOnActon(ActionEvent actionEvent) {
    }
}
