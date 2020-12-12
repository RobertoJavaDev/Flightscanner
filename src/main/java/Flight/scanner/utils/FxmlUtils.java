package Flight.scanner.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ResourceBundle;

public class FxmlUtils {

    public static Pane fxmlLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
        loader.setResources(getResourceBundle());
        try {
            return loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

        public static ResourceBundle getResourceBundle(){
            return ResourceBundle.getBundle("bundles.messages_eng");
        }

        public static FXMLLoader getLoader(String fxmlPath) throws IOException {
            FXMLLoader loader = new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
            loader.setResources(getResourceBundle());
            return loader.load();
        }
}
