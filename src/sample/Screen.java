package sample;

/**
 * Class Screen takes and returns information for the ScreenSpec functions. Screen is a feature of
 * ItemType.Visual and ItemType.VisualMobile
 *
 * @author carolinabado
 */
public class Screen implements ScreenSpec {
  private String resolution;
  private int refreshrate;
  private int responsetime;

  /**
   * Method Screen gets information for the ItemType.Visual or ItemType.VisualMobile
   *
   * @param resolution -resolution of the screen spec. Must be a String
   * @param refreshrate -how long does it take refresh the screen
   * @param responsetime - time it takes to respond
   */
  public Screen(String resolution, int refreshrate, int responsetime) {
    this.resolution = resolution;
    this.refreshrate = refreshrate;
    this.responsetime = responsetime;
  }

  /**
   * String method that prints resolution, refresh rate and response time.
   *
   * @return Product's resolution, refresh rate and response time
   */
  public String toString() {
    return "Resolution: "
        + resolution
        + "\n"
        + "Refresh rate: "
        + refreshrate
        + "\n"
        + "Response time: "
        + responsetime;
  }

  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshrate;
  }

  @Override
  public int getResponseTime() {
    return responsetime;
  }
}
