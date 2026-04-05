package smartHomeSystem.devices;

public class SmartSpeaker implements SmartDevice {
  private boolean is_open;
  final String name;

  public SmartSpeaker(){
    is_open = false;
    name = "speaker";
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
    if (is_open) return "speaker is on";
    else return "speaker is off";
  }
}

