package Flight.scanner.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

import javax.swing.border.Border;

public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TopMenuButtonsController topMenuButtonsController;

    @FXML
    private void initialize(){
        topMenuButtonsController.setMainController(this);

    }

}
