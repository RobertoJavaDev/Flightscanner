package Flight.scanner.controllers;

import Flight.scanner.modelFX.*;
import Flight.scanner.utils.DialogsUtils;
import Flight.scanner.utils.exceptions.ApplicationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


public class FlightController {

    private FlightModel flightModel;
    private AirlineModel airlineModel;
    private CityModel cityModel;

    @FXML
    private ComboBox<AirlineFx> airlineComboBoxAirline;

    @FXML
    private ComboBox<CityFx> cityComboBoxDeparture;

    @FXML
    private ComboBox<CityFx> cityComboBoxArrival;

    @FXML
    public void initialize(){
        this.flightModel = new FlightModel();
        this.airlineModel = new AirlineModel();
        this.cityModel = new CityModel();
        try {
            this.flightModel.init();
            this.airlineModel.init();
            this.cityModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.airlineComboBoxAirline.setItems(this.airlineModel.getAirlineList());
        this.cityComboBoxDeparture.setItems(this.cityModel.getCityList());
        this.cityComboBoxArrival.setItems(this.cityModel.getCityList());
    }

    public void onActionComboBoxAirline() {
        this.airlineModel.setAirline(this.airlineComboBoxAirline.getSelectionModel().getSelectedItem());
    }

    public void onActionComboBoxDeparture() {
        this.cityModel.setCity(this.cityComboBoxDeparture.getSelectionModel().getSelectedItem());
    }

    public void onActionComboBoxArrival() {
        this.cityModel.setCity(this.cityComboBoxArrival.getSelectionModel().getSelectedItem());
    }
}
