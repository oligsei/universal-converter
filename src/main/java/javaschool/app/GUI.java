package javaschool.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
    public static void main(String[] args) {
        Application.launch(GUI.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Scene scene = new Scene(FXMLLoader.load(Main.class.getResource("/main_window.fxml")));
        stage.setScene(scene);
        stage.setTitle("Universal converter");
        stage.show();
    }

}
