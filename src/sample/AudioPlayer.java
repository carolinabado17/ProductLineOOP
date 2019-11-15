package sample;

/**
 * Gets characteristics from MultimediaControl from the ItemType.Audio any type Audio gets these
 * characteristics plus MultimediaControl
 *
 * @author carolinabado
 */
public class AudioPlayer extends Product implements MultimediaControl {

  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  /**
   * Constructor holds information from the class Product. take the info and overload it to
   * AudioPlayer
   *
   * @param name - name of the product taken form the user interface
   * @param manufacturer - manufacturer of the product
   * @param supportedAudioFormats - what audio formats the product supports taking a String
   * @param supportedPlaylistFormats - the playlist formats that are supported by the product. Only
   *     accepts a String
   */
  AudioPlayer(
      String name,
      String manufacturer,
      String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.Audio);

    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  @Override
  public String toString() {
    return super.toString()
        + "Supported Audio Formats: "
        + supportedAudioFormats
        + "\n"
        + "Supported Playlist Formats: "
        + supportedPlaylistFormats;
  }

  /** Prints out the features that the product is doing. */
  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  /**
   * Gets Product Type and returns it.
   *
   * @param type - get the type the user declared it to be
   * @return the type
   */
  @Override
  public ItemType getType(ItemType type) {
    return type;
  }
}
