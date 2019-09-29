package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  // fix formatting-> command-option-shift-'L'
  @Override
  public void start(Stage primaryStage) throws Exception {


    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

    Scene scene = new Scene(root, 500, 400);
    primaryStage.setScene(scene);
    scene.getStylesheets().add(Main.class.getResource("productLine.css").toExternalForm());
    primaryStage.setTitle("OOP Project - Product Line");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
