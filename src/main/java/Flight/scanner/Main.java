package Flight.scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    private static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader (this.getClass().getResource(BORDER_PANE_MAIN_FXML));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages_eng");
        loader.setResources(bundle);
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(bundle.getString("title.application"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

