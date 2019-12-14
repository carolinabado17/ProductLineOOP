package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller class connects to the DB and GUI.
 *
 * @author carolinabado
 */
public class Controller {

  @FXML private ComboBox dropDown;
  @FXML private Button addProd;
  @FXML private Button recordProd;
  @FXML private ChoiceBox<ItemType> itemTypeCB;
  @FXML private TableView<Product> tbvProduct;
  @FXML private TableColumn<?, ?> productTbc;
  @FXML private TableColumn<?, ?> tbcManufacturer;
  @FXML private TableColumn<?, ?> tbcType;
  @FXML private TextField txtProduct;
  @FXML private TextField txtMan;
  @FXML private ObservableList<Product> productList = FXCollections.observableArrayList();
  @FXML private ListView<Product> chooseProdLV;
  @FXML private TextArea productionLog;
  @FXML private TextField usernameInput;
  @FXML private TextField pwInput;
  @FXML private TextArea empDetails;
  Connection conn;
  /**
   * method runs once application has started its going to load the comboList and connect to DB.
   * (database)
   */
  @FXML
  public void initialize() {

    productTbc.setCellValueFactory(new PropertyValueFactory<>("name"));
    tbcManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
    tbcType.setCellValueFactory(new PropertyValueFactory<>("type"));



    chooseProdLV.setItems(productList);

    tbvProduct.setItems(productList);

    itemTypeCB();

    List<String> comboList = new ArrayList<>();

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


    final String Jdbc_Driver = "org.h2.Driver";
    final String DB_url = "jdbc:h2:./res/productDB";

    try {
      // Register JDBC Driver
      Class.forName(Jdbc_Driver);

      // open connection
      conn = DriverManager.getConnection(DB_url, user, pass);

      // execute a query
      // stmt = conn.createStatement();

      //conn.close();
      // stmt.close();

    } catch (Exception e) {
      e.printStackTrace();
    } // end try catch
  }

  private void itemTypeCB() {
    itemTypeCB.setItems(FXCollections.observableArrayList(ItemType.values()));
  }

  /**
   * Records Production amount and displays on productionLog.
   *
   * @param actionEvent - when the button is clicked it adds to the ProductionLog
   */
  @FXML
  public void recProduction(ActionEvent actionEvent) {
    Product item2Produce = chooseProdLV.getSelectionModel().getSelectedItem();

    /* Wasn't working at first it was hardcoded from repl.it to 3.
    Had to convert it twice for it to work from int to string back to int.
     */

    int numProduced = 0;
    String stringNumProd = String.valueOf(dropDown.getValue());

    numProduced = Integer.parseInt(stringNumProd); // this will come from the combobox in the UI
    int itemCount = 0;

    for (int productionRunProduct = 0; productionRunProduct < numProduced; productionRunProduct++) {
      ProductionRecord pr = new ProductionRecord(item2Produce, itemCount++);
      // using the iterator as the product id for testing

      System.out.println(pr.toString());
      System.out.println("Production has been recorded");
      productionLog.appendText(pr.toString() + '\n');
    }
  }

  /**
   * Adds Product to the TableView.
   *
   * @param actionEvent button is clicked adds product to the tableView
   */
  public void addProduct(ActionEvent actionEvent) {

    String nameUser = txtProduct.getText();
    String manUser = txtMan.getText();
    ItemType typeUser = itemTypeCB.getValue();

    System.out.println("Product has been added");

    try {
      String sql = "INSERT INTO Product(NAME, TYPE, MANUFACTURER) VALUES ( ?, ?, ?)";
      PreparedStatement productAdd = conn.prepareStatement(sql);
      productAdd.setString(1,nameUser);
      productAdd.setString(2,manUser);
      productAdd.setString(3,typeUser.toString());
      productAdd.executeUpdate();
      // adds products to the ObvList and display it to the tableView
      productList.add(new Widget(nameUser, manUser, typeUser));
      System.out.println(productList);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  /**
   * Button pressed creates a User.
   *
   * @param event - when button is clicked it creates user and displays the details.
   */
  @FXML
  void createUser(ActionEvent event) {
    if (usernameInput.getText().equals("") || pwInput.getText().equals("")) {
      Alert a = new Alert(Alert.AlertType.WARNING);
      a.setAlertType(Alert.AlertType.WARNING);
      a.setContentText("Please Fill In The Fields With --> *");
      a.show();
    }else{
      Employee employee = new Employee(usernameInput.getText(), pwInput.getText());
      empDetails.setText(employee.toString());
      empDetails.setEditable(false); // you cant edit the details when printed out
      /*
      this clears the text fields after LogIn button has been pressed. Allows functionality.
       */
      usernameInput.clear();
      pwInput.clear();}

  }

}
