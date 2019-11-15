package sample;

/**
 * Stores functions for all the Item's to use. holds getters and setters
 *
 * @author carolinabado
 */
public interface Item {

  int getId();

  void setName(String name);

  String getName();

  void setManufacturer(String manufacturer);

  String getManufacturer();

  void setType(ItemType type);

  ItemType getType(ItemType type);
}
