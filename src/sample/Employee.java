package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class takes employee name, makes a username for them to access the products.
 *
 * @author carolinabado
 */
public class Employee {

  private StringBuilder name;
  private String username;
  private String password;
  private String email = "user@oracleacademy.Test";

  /**
   * Overloaded constructor Employee, checks if username and pass are correct.
   *
   * @param name - the name of the Employee
   * @param password - the password
   */
  public Employee(String name, String password) {
    this.name = new StringBuilder(name);
    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    } else {
      username = "default";
    }

    if (isValidPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }
  }

  /**
   * Method that takes the name of the Employee and converts it to be a username. Uses first and
   * last name.
   *
   * @param name - name of the employee
   */
  private void setUsername(String name) {

    Pattern firstLast = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher firstLastMatching = firstLast.matcher(name);
    firstLastMatching.find();
    String lastName = firstLastMatching.group(1);
    String initials = name.substring(0, 1) + lastName;
    this.username = initials.toLowerCase();
  }

  /**
   * Checks the name.
   *
   * @param name - the input name.
   * @return - returns the checked name.
   */
  private boolean checkName(String name) {
    Pattern checkPattern = Pattern.compile("\\s");
    Matcher patternMatch = checkPattern.matcher(name);
    boolean check = patternMatch.find();
    return check;
  }

  /**
   * Creates the email for the user using their name.
   *
   * @param name
   */

  private void setEmail(String name) {

    Pattern firstNameCheck = Pattern.compile("(.*)\\s", Pattern.MULTILINE);
    Matcher firstMatched = firstNameCheck.matcher(name);
    firstMatched.find();
    String firstName = firstMatched.group(1);

    Pattern lastNameCheck = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher lastMatched = lastNameCheck.matcher(name);
    lastMatched.find();
    String lastName = lastMatched.group(1);

    this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@oracleacademy.Test";
  }

  /**
   * Checks to see the password is proper syntax.
   *
   * @param password - user's assigned password
   * @return - the user's password
   */

  private boolean isValidPassword(String password) {

    final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).*$";
    final Pattern regexCD = Pattern.compile(regex);
    final Matcher matched = regexCD.matcher(password);
    return matched.matches();
  }

  /**
   * String method that prints out the Employee details.
   *
   * @return - user'name, its username, email, and displays the password.
   */

  public String toString() {
    return "\n"
        + "Name: "
        + name
        + "\n"
        + "Username: "
        + username
        + "\n"
        + "Email: "
        + email
        + "\n"
        + "Initial Password: "
        + password;
  }
}


