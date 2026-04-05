package smartHomeSystem.factory;

import smartHomeSystem.devices.SmartDevice;

public abstract class DeviceFactory {
  public abstract SmartDevice createDevice();
}