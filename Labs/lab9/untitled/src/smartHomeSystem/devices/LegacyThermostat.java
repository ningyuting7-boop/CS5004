package smartHomeSystem.devices;

public class LegacyThermostat {
  private int currentTemp;
  public void activate() { currentTemp = 80; }
  public void deactivate() { currentTemp = 0;}
  public int getCurrentTemp() {
    return currentTemp;
  }
}
