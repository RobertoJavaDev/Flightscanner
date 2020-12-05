package Flight.scanner;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    private static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Flight scanner");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

