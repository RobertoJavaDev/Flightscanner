package Flight.scanner.controllers;

import Flight.scanner.modelFX.AirlineFx;
import Flight.scanner.modelFX.AirlineModel;
import Flight.scanner.utils.DialogsUtils;
import Flight.scanner.utils.exceptions.ApplicationException;
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
        try {
            this.airlineModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.airlineCombobox.setItems(this.airlineModel.getAirlineList());
        initBindings();
    }

    private void initBindings() {
        this.addAirlineButton.disableProperty().bind(airlineTextField.textProperty().isEmpty());
        this.deleteAirlineButton.disableProperty().bind(this.airlineModel.airlineProperty().isNull());
        this.editAirlineButton.disableProperty().bind(this.airlineModel.airlineProperty().isNull());
    }

    public void addAirlineOnActon(){
        try {
            airlineModel.saveAirlineInDataBase(airlineTextField.getText());
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        airlineTextField.clear();
    }

    public void deleteAirlineOnAction() {
        try {
            this.airlineModel.deleteAirlineById();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    public void onActionComboBox() {
        this.airlineModel.setAirline(this.airlineCombobox.getSelectionModel().getSelectedItem());

    }

    public void editOnAction(){
        String newAirlineName = DialogsUtils.editDialog(this.airlineModel.getAirline().getAirline());
        if (newAirlineName!=null){
            this.airlineModel.getAirline().setAirline(newAirlineName);
            try {
                this.airlineModel.updateAirlineInDatabase();
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }
        }
    }
}
