package Flight.scanner.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

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
        mainController.setCenter("/fxml/AddCity.fxml");
    }

    @FXML
    public void addAirline(ActionEvent actionEvent) {
        resetToggleButtons();
        mainController.setCenter("/fxml/AddAirline.fxml");
    }

    public void addConfig(ActionEvent actionEvent) {
        resetToggleButtons();
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
