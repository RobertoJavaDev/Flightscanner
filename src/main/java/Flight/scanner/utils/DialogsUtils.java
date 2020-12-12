package Flight.scanner.utils;

import javafx.scene.control.Alert;

import javax.swing.*;
import java.util.ResourceBundle;

public class DialogsUtils {

    static ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages_eng");

    public static void dialogAboutApplication(){
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString(("about.title")));
        informationAlert.setHeaderText(bundle.getString("about.header"));
        informationAlert.setContentText(bundle.getString("about.content"));
        informationAlert.showAndWait();

    }
}
