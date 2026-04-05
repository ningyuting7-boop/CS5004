package smartHomeSystem.factory;

import smartHomeSystem.devices.SmartDevice;
import smartHomeSystem.devices.SmartLight;

public class LightFactory extends DeviceFactory {
  @Override
  public SmartDevice createDevice() {
    return new SmartLight();
  }
}