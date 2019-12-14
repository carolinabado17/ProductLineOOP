package sample;

/**
 * Enables the program to access the Abstract Product class.
 *
 * @author carolinabado
 */
public class Widget extends Product {
  Widget(String n, ItemType t, String m) {
    super(n, t, m);
  }

  @Override
  public void setType(ItemType type) {

  }

  @Override
  public ItemType getType(ItemType type) {
    return type;
  }
}
