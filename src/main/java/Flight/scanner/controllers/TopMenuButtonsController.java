package Flight.scanner.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController { 

    public static final String CITY_FXML = "/fxml/AddCity.fxml";
    public static final String AIRLINE_FXML = "/fxml/AddAirline.fxml";
    public static final String FLIGHT_FXML = "/fxml/AddFlight.fxml";
    private MainController mainController;

    @FXML
    private ToggleGroup toggleButtons;

    @FXML
    public void openListOfFlights(ActionEvent actionEvent) {
    }

    @FXML
    public void openListOfPrices(ActionEvent actionEvent) {
    }

    @FXML
    public void openListOfCities(ActionEvent actionEvent) {
    }

    @FXML
    public void addCity(ActionEvent actionEvent) {
        resetToggleButtons();
        mainController.setCenter(CITY_FXML);
    }

    @FXML
    public void addAirline(ActionEvent actionEvent) {
        resetToggleButtons();
        mainController.setCenter(AIRLINE_FXML);
    }

    public void addFlight(ActionEvent actionEvent) {
        resetToggleButtons();
        mainController.setCenter(FLIGHT_FXML);
    }

    private void resetToggleButtons(){
        if (toggleButtons.getSelectedToggle() != null) {
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


}
