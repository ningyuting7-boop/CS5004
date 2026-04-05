package smartHomeSystem.factory;

import smartHomeSystem.devices.SmartDevice;
import smartHomeSystem.devices.SmartSpeaker;

public class SpeakerFactory extends DeviceFactory {
  @Override
  public SmartDevice createDevice() {
    return new SmartSpeaker();
  }
}