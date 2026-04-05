package smartHomeSystem.facade;

import smartHomeSystem.controller.SmartHomeController;

public class SmartHomeFacade {
  private SmartHomeController controller;

  public SmartHomeFacade(SmartHomeController controller) {
    this.controller = controller;
  }

  public void activateNightMode() {
    controller.turnOffAllDevices(); // 关闭灯、音箱
    System.out.println("Night mode activated");
  }

  public void leaveHome() {
    controller.turnOffAllDevices();
    System.out.println("All devices turned off. Leaving home.");
  }

}
