package sample;

public enum ItemType {
  Audio("AU"),
  Visual("VI"),
  AudioMobile("AM"),
  VisualMobile("VM");

  public final String code;

  ItemType(String code) {
    this.code = code;
  }
}
