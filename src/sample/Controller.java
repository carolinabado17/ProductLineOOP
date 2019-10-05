package sample;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Controller {

  private Statement stmt;

  @FXML ComboBox dropDown;

  public void addProduct(javafx.event.ActionEvent actionEvent) {
    System.out.println("Product has been added");
  }

  public void recProduction(javafx.event.ActionEvent actionEvent) {
    System.out.println("Production has been recorded");
  }

  /**
   * method runs once application has started its going to load the comboList and connect to DB.
   * (database)
   */
  @FXML
  public void initialize() {

    List<String> comboList = new ArrayList<String>();

    // Populating w.values 1-10
    comboList.add("1");
    comboList.add("2");
    comboList.add("3");
    comboList.add("4");
    comboList.add("5");
    comboList.add("6");
    comboList.add("7");
    comboList.add("8");
    comboList.add("9");
    comboList.add("10");

    ObservableList observList = FXCollections.observableList(comboList);

    dropDown.getItems().clear();
    dropDown.setItems(observList);
    dropDown.getSelectionModel().selectFirst();
    dropDown.setEditable(true);

    //  Database credentials
    final String user = "";
    final String pass = "";
    Connection conn;

    final String Jdbc_Driver = "org.h2.Driver";
    final String DB_url = "jdbc:h2:./res/productDB";

    try {
      // Register JDBC Driver
      Class.forName(Jdbc_Driver);

      // open connection
      conn = DriverManager.getConnection(DB_url, user, pass);

      // execute a query
      stmt = conn.createStatement();

      // hardcoding
      String sql =
          "INSERT INTO Product(type, manufacturer, name)" + "VALUES ( 'AUDIO', 'Apple', 'iPod')";
      stmt.executeUpdate(sql);

      conn.close();
      stmt.close();

    } catch (Exception e) {
      e.printStackTrace();
    } // end try catch
  }

  public enum ItemType {
    Audio("AU"),
    Visual("VI"),
    AudioMobile("AM"),
    VisualMobile("VM");

    private final String code;

    ItemType(String code) {
      this.code = code;
    }
  }
}
