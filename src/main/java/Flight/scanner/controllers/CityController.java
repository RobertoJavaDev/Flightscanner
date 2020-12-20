package Flight.scanner.controllers;

import Flight.scanner.modelFX.CityFx;
import Flight.scanner.modelFX.CityModel;
import Flight.scanner.utils.DialogsUtils;
import Flight.scanner.utils.exceptions.ApplicationException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;


public class CityController {

    @FXML
    private Button addCityButton;

    @FXML
    private Button editCityButton;

    @FXML
    private Button deleteCityButton;

    @FXML
    private TextField cityTextField;

    @FXML
    private ComboBox<CityFx> cityCombobox;
    private CityModel cityModel;

    @FXML
    private TreeView<String> cityTreeView;

    @FXML
    public void initialize(){
        this.cityModel = new CityModel();
        try {
            this.cityModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.cityCombobox.setItems(this.cityModel.getCityList());
        this.cityTreeView.setRoot(this.cityModel.getRoot());
        initBindings();
    }
    private void initBindings() {
        this.addCityButton.disableProperty().bind(cityTextField.textProperty().isEmpty());
        this.deleteCityButton.disableProperty().bind(this.cityModel.airlineProperty().isNull());
        this.editCityButton.disableProperty().bind(this.cityModel.airlineProperty().isNull());
    }

    public void addCityOnAction(){
        try {
            cityModel.saveCityInDataBase(cityTextField.getText());
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        cityTextField.clear();
    }

    public void deleteCityOnAction() {
        try {
            this.cityModel.deleteCityById();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    public void onActionComboBox() {
        this.cityModel.setCity(this.cityCombobox.getSelectionModel().getSelectedItem());

    }

    public void editOnAction(){
        String newCityName = DialogsUtils.editDialog(this.cityModel.getCity().getCity());
        if (newCityName!=null){
            this.cityModel.getCity().setCity(newCityName);
            try {
                this.cityModel.updateCityInDatabase();
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }
        }
    }

}
