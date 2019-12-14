package sample;

/**
 * Holds characteristics for ItemType.Visual products.
 *
 * @author carolinabado
 */
public class MoviePlayer extends Product implements MultimediaControl {

  private Screen screen;
  private MonitorType monitorType;

  /**
   * Constructor that takes screen and monitorType.
   *
   * @param name name of the product
   * @param manufacturer manufacturer of the product
   * @param screen gives you the type of screen
   * @param monitorType tells you if its LCD or LED
   */
  MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name,  ItemType.Visual,manufacturer);

    this.screen = screen;
    this.monitorType = monitorType;
  }

  @Override
  public String toString() {
    return super.toString() + "Screen:" + screen + "\n" + "Monitor Type: " + monitorType;
  }

  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  @Override
  public void next() {
    System.out.println("Next movie");
  }

  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  @Override
  public ItemType getType(ItemType type) {
    return type;
  }
}
