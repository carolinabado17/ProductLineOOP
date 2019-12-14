# ProductLine OOP

This project is an assigment for COP 3003 (Object-Oriented Programming) course at Florida Gulf Coast University. This project was started in August, 2019 and finsihed December 13, 2019. <br />
The program provides a UI to allow user to create products store them in a DB and generate a production log. It also provides the user with an Employee tab so they are able to login as well as create an account. 


## Demonstration

*comming soon*

## Documentation

[JavaDoc](https://carolinabado17.github.io/ProductLineOOP/)

## Diagrams
Class Diagram
 ![Class Diagram](OOPLineClassDiagram.png)
 <br />
 Database Diagram<br />
 ![DB Diagram](diagramDB.png)
 

## Getting Started

*jar file coming soon* <br />
* Windows:<br />
  * Extract the <PROJECT FOLDER NAME> folder to C:\Users\**YOUR USERNAME**\IdeaProjects<br />
* Mac:<br />
  * Extract the <PROJECT FOLDER NAME> folder to Directory: /Users/**YOUR USERNAME**/EventFinder <br />
* IDE<br />
  * File > New > Project From version control > Enter URL/HTTP > Choose the directory for project > clone<br />
  
## Built With

* IntelliJ IDE <br />
* JavaFX <br />
* SceneBuilder (for GUI) <br /> 
* Database --> H2 and SQL <br />


## Contributing

* Increase Security <br /> 
* Enhancements on Human User Factors (wrong inputs, not all fields are filled, etc) <br /> 

## Author

* Carolina Bado-Cortes

## License

https://github.com/carolinabado17/ProductLineOOP/blob/master/LICENSE

## Acknowledgments

* Professor Scott Vanselow <br />
* class mates: Louis Sze, José Rivera<br />
* GeeksforGeeks (https://www.geeksforgeeks.org/javafx-alert-with-examples/)<br />
* Regular expressions.info (https://www.regular-expressions.info/tutorial.html) <br />
* To populate database (https://www.youtube.com/watch?v=LoiQVoNil9Q) 

## History
 * this information was taken from Prof. Vanselow's website * <br />
Sprint 1 (ALPHA) <br />
WEEK 1 <br />
* Created JavaFX project. <br />
* Shared to private repo on GitHub. <br />
* Created README. <br />

WEEK 2<br />
* Added a tab view with 3 tabs : Product Line, Produce, and Production Log <br />
* Added a CSS file with some code. <br />

WEEK 3 <br />
* In Product Line tab: <br />
  * In the Anchor Pane<br />
    * Added a 2x3 GridPane <br />
      * Added label and text field for Product Name<br />
      * Added label and text field for Manufacturer<br />
      * Added label and choiceBox for ItemType<br />
    * Added button - Add Product <br />
      * Added event handler to the button click event.<br />
    * Added label and a table View for Existing Products <br />
  * Produce Tab - in the AnchorPane<br />
    * added a label and listView for Choose Product. <br />
    * added label and comboBox for Choose Quantity. <br />
    * Created button - Record Production <br />
  * Production Log Tab - added text area <br />
  
WEEK 4<br />
* installed db software, created db in res folder <br />
* connected to DB <br />

WEEK 5 <br />
* In the Product Line tab, for the Add Product button event handler, add code to insert a product into the database <br />
* Built a sql statement to get the values from UI <br />
* Populated the combobox (in ProduceTab) with values 1-10 <br />

Sprint 2 (BETA)<br />
WEEK 6<br />
* created a enum (itemType) <br />
* filled the choiceBox with the types from the Enum. <br />
* Interface called Item with methods <br />
* created an abstract type called Product<br />
  * holds int id, string type, string manufacturer, and string name <br />
* created a constructor to take the the objects from the abstract class. <br />
* created a toString() method<br />

WEEK 7 <br />
* created an interface called Multimedia Controll with 4 methods <br />
* Audio Player class that is a subclass of Product and implements Multimedia Control <br />
  * constructor to take 4 parameters<br />
  * it calls the parent's constructor and sets up the mediatype to AUDIO <br />
* created anothe toString() method. <br />

WEEK 8 <br />
* created enum Monitor Type with 2 types (LCD and LED) <br />
* ScreenSpec interface that defines 3 methods <br />
* Screen class implements ScreenSpec <br />
  * added 3 fields (String resolution, int refreshrate, int responsetime)<br />
* MoviePlayer class that extends to Product and implements MultimediaControl<br />
  * sets up the item type to VISUAL <br />

WEEK 9 <br />
* created a ProductionRecord concrete class (gets auto-incremented by the db) <br />
* added getters and setter for all fields <br />
* created constructor that has a parameter productID, this will be called when the user records production from the user interface<br />
* display the production record in textArea in Production Log tab <br />

WEEK 10 <br />
* generate a unique serial number <br />
  * serial number should start with first 3 letters of the man, then 2 letters from the ItemType code, then 5 digits (with leading 0's)<br />

WEEK 11 <br />
* show all products in the product line tab tableView <br />
* created observable list (productList) to hold all products that can be produced.<br />
* set the items of the TableView to the observableList <br />
* show all products in the produce tab listView<br />
* show the production log in the production log tab TextArea<br />

Sprint 3 (RELEASE)<br />
WEEK 12 <br />
* check that h2 dirver jar file was copied to my res folder<br />
* Controller initialize method does the following when the program starts:<br />
  * define the ObservableList <br />
  * call setupProductLineTable <br />
  * associate the ObservableList with the Product Line ListView <br />
  * call loadProductList <br />
  * call loadProductionLog <br />
* add product button does the following: <br />
  * insert added product into database <br />
  * call loadProductList <br />
* loadProductList does the following: <br />
  * create Product objects from the Product DB table and adds them to the productList ObservableList <br />
* Record Production button does the following:  <br />
  * Gets the selected product from the Product Line ListView and the quantity from the comboBox. <br />
  * Creates an ArrayList of ProductionRecord objects named productionRun. <br />
  * Send the productionRun to an addToProductionDB method. <br />
  * call loadProductionLog<br />
  * call showProduction<br />
* showProduction does: <br />
  * populates the TextArea on the Production Log tab with the information from the productionLog, replacing the productId with the product name, with one line for each product produced <br />
* addToProductionDB method does the following:<br />
  * Loop through the productionRun, inserting productionRecord object information into the           ProductionRecord database table.<br />
* loadProductionLog method does:<br />
  * Create ProductionRecord objects from the records in the ProductionRecord database table. <br />
  * Populate the productionLog ArrayList<br />
  * call showProduction<br />

WEEK 13 <br />
* set the db password and read the password from a file <br />
* created 4 fields for the class (name, username, password, email) <br />
* methods:<br />
  * private void setUsername<br />
  * private boolean checkName<br />
  * private void setEmail<br />
  * private boolean isValidPassword<br />
* constructor will checkName (if the name contains a space. If it does, it will call setUsername and setEmail, passing the name in to both. If it doesn't contain a space, set the username to "default" and the email to "user@oracleacademy.Test") <br />
* setUsername will set the username field to the first initial of the first name and then the last name, all lowercase. <br />
* setEmail will set the email field to the first name, then a period, then the last name (all lowercase) followed by @oracleacademy.Test<br />


## Key Programming Concepts Utilized

enums - Java type used to define collections of constants (may contain constants as well as methods) <br />
interface - tells a class what to do but DOES NOT do it. (blueprint for class)<br />
abstract - used as a base to extend or implement classes. Used to 'hide' uneccessary info and displaying only essential information to the user. <br />
inheritance - mechanism in OOP where an object can accquire all of the properties of a parent class. <br />
polymorphism - 'many forms' we can perform a method in many different ways by using overriding and overloading <br />
encapsulation - wrapping data and the code into a single unit. <br />
lambda expressions - fucntion that can be created wihtout having to belong to any class also allows to express instances of single method classes<br />
recursion - when a method calls itself<br />
implement - key word for interfaces when they are implemented by another class. <br />
extending - you are creating a subclass of the base class you are extending (key word)<br />


