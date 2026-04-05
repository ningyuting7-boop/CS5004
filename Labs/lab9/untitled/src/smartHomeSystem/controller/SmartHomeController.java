package smartHomeSystem.controller;

import java.util.ArrayList;
import java.util.List;
import smartHomeSystem.devices.SmartDevice;

public class SmartHomeController {
  private static SmartHomeController instance;
  private List<SmartDevice> devices = new ArrayList<>();

  // private controller
  private SmartHomeController(){};

  public static SmartHomeController getInstance(){
    if (instance == null) {
      instance = new SmartHomeController();
    }
    return instance;
  }
  public void addDevice(SmartDevice device) { devices.add(device); }
  public void turnOnAllDevices() { devices.forEach(SmartDevice::turnOn); }
  public void turnOffAllDevices() { devices.forEach(SmartDevice::turnOff); }
  public void showStatus() { devices.forEach(d -> System.out.println(d.getStatus())); }
}

