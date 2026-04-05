package smartHomeSystem;

import smartHomeSystem.controller.SmartHomeController;
import smartHomeSystem.devices.LegacyThermostat;
import smartHomeSystem.devices.LegacyThermostatAdapter;
import smartHomeSystem.devices.SmartDevice;
import smartHomeSystem.facade.SmartHomeFacade;
import smartHomeSystem.factory.DeviceFactory;
import smartHomeSystem.factory.LightFactory;
import smartHomeSystem.factory.SpeakerFactory;

public class Main {
  public static void main(String[] args) {

    // --- Singleton Pattern ---
    // Both calls return the same instance
    SmartHomeController controller = SmartHomeController.getInstance();
    SmartHomeController controller2 = SmartHomeController.getInstance();
    System.out.println("=== Singleton Pattern ===");
    System.out.println("Same controller instance: " + (controller == controller2));

    // --- Factory Method Pattern ---
    System.out.println("\n=== Factory Method Pattern ===");
    DeviceFactory lightFactory = new LightFactory();
    DeviceFactory speakerFactory = new SpeakerFactory();

    SmartDevice light = lightFactory.createDevice();
    SmartDevice speaker = speakerFactory.createDevice();
    System.out.println("Created via LightFactory:   " + light.getStatus());
    System.out.println("Created via SpeakerFactory: " + speaker.getStatus());

    controller.addDevice(light);
    controller.addDevice(speaker);

    // --- Adapter Pattern ---
    System.out.println("\n=== Adapter Pattern ===");
    LegacyThermostat oldThermostat = new LegacyThermostat();
    SmartDevice thermostatAdapter = new LegacyThermostatAdapter(oldThermostat);
    System.out.println("Thermostat via adapter (before turnOn): " + thermostatAdapter.getStatus());
    thermostatAdapter.turnOn();
    System.out.println("Thermostat via adapter (after turnOn):  " + thermostatAdapter.getStatus());
    controller.addDevice(thermostatAdapter);

    // --- All device status before facade ---
    System.out.println("\n=== All Devices Status (all ON) ===");
    controller.turnOnAllDevices();
    controller.showStatus();

    // --- Facade Pattern ---
    System.out.println("\n=== Facade Pattern: activateNightMode() ===");
    SmartHomeFacade facade = new SmartHomeFacade(controller);
    facade.activateNightMode();
    controller.showStatus();

    System.out.println("\n=== Facade Pattern: leaveHome() ===");
    controller.turnOnAllDevices();
    facade.leaveHome();
    controller.showStatus();
  }
}