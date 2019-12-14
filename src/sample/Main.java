package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main Class.
 *
 * @author carolinabado
 */
public class Main extends Application {

  // fix formatting-> command-option-shift-'L'

  /**
   * Main Class connects css file to the fxml file.
   *
   * @param primaryStage the primary Stage
   * @throws Exception any errors or problems when running the program
   */
  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

    Scene scene = new Scene(root, 510, 595);
    primaryStage.setScene(scene);
    scene.getStylesheets().add(Main.class.getResource("productLine.css").toExternalForm());
    primaryStage.setTitle("OOP Project - Product Line");
    primaryStage.show();
  }

  /**
   * Prints out products in the command line.
   *
   * @param args Stores array of String it stores arguments that are passed by the command line
   */
  public static void main(String[] args) {
    launch(args);
  }

  {
    AudioPlayer newProduct =
        new AudioPlayer(
            "DP-X1A", "Onkyo", "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    System.out.println(newProduct);
    newProduct.play();
    newProduct.stop();
    newProduct.next();
    newProduct.previous();
  }
}
