package sample;

/**
 * Stores function that ItemType.&nbsp;Type uses for MonitorType. main differences between the audio
 * players is the screens these are screen functions
 *
 * @author carolinabado
 */
public interface ScreenSpec {
  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
