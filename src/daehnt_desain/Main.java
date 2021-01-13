package daehnt_desain;

/*
A main class to start the Application
Tyler Daehn
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("daehnt_desain/FlowerBed.fxml"));
        fxmlLoader.load();
        GardenController gardenController = fxmlLoader.getController();
        primaryStage.setScene(gardenController.displayScene());
        primaryStage.setTitle("Bee Runner 2049");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    public Main() {
    }

    public static void main(String[] args) {
        launch(args);
    }
}
