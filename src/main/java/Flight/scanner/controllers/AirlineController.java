package Flight.scanner.controllers;

import Flight.scanner.modelFX.AirlineFx;
import Flight.scanner.modelFX.AirlineModel;
import Flight.scanner.utils.DialogsUtils;
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
        this.editAirlineButton.disableProperty().bind(this.airlineModel.airlineProperty().isNull());
    }

    public void addAirlineOnActon() {
        airlineModel.saveAirlineInDataBase(airlineTextField.getText());
        airlineTextField.clear();
    }

    public void deleteAirlineOnAction() {
        this.airlineModel.deleteAirlineById();
    }

    public void onActionComboBox() {
        this.airlineModel.setAirline(this.airlineCombobox.getSelectionModel().getSelectedItem());

    }

    public void editOnAction() {
        String newAirlineName = DialogsUtils.editDialog(this.airlineModel.getAirline().getAirline());
        if (newAirlineName!=null){
            this.airlineModel.getAirline().setAirline(newAirlineName);
            this.airlineModel.updateAirlineInDatabase();
        }
    }
}
