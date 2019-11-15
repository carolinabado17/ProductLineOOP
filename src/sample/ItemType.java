package sample;

/**
 * The products different types. Each product can be categorized into these four main characteristic
 *
 * @author carolinabado
 */
public enum ItemType {
  Audio("AU"),
  Visual("VI"),
  AudioMobile("AM"),
  VisualMobile("VM");

  private String label;

  /**
   * Constructor gets label of the ItemType in the form of a String.
   *
   * @return - label, the abbreviation of the type chosen
   */
  public String getLabel() {
    return label;
  }

  ItemType(String c) {
    label = c;
  }
}
