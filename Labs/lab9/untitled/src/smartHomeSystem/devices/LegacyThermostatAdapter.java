package smartHomeSystem.devices;

public class LegacyThermostatAdapter implements SmartDevice {
  private LegacyThermostat legacyThermostat;
  public LegacyThermostatAdapter(LegacyThermostat thermostat){
    this.legacyThermostat = thermostat;
  }
  public void turnOn(){legacyThermostat.activate();}
  public void turnOff(){legacyThermostat.deactivate();}
  public String getStatus(){ return "thermostat temperature: " + legacyThermostat.getCurrentTemp();}


}
