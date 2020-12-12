package Flight.scanner;

import Flight.scanner.utils.FxmlUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public void start(Stage primaryStage) throws Exception {
        Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

