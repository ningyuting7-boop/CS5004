package smartHomeSystem.devices;

public class SmartLight implements SmartDevice {
  private boolean is_open;
  final String name;
  public SmartLight(){
    is_open = false;
    name = "light";
  }

  @Override
  public void turnOn() {
    if (is_open == false){
      is_open = true;
    }
  }
  public void turnOff(){
    if (is_open == true){
      is_open = false;
    }
  }
  public String getStatus(){
    if (is_open) return "light is on";
    else return "light is off";
  }
}
