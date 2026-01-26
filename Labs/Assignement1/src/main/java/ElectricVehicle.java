import java.text.DecimalFormat;
/**
 * Represents an Electric Vehicle (EV) with battery, efficiency,
 * and state-of-charge related behaviors.
 */
public class ElectricVehicle {
  private String name;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private double defaultEfficiency;
  /**
   * Constructs an ElectricVehicle with the given parameters.
   *
   * @param name the name of the EV; if null or empty, defaults to "unknown EV"
   * @param batterySize battery size in kWh (10–150)
   * @param stateOfCharge state of charge as a decimal (0.15–1.0)
   * @param defaultEfficiency default efficiency (0.5–4.5)
   */
  public ElectricVehicle(String name, double batterySize, double stateOfCharge, double defaultEfficiency){
    // Validate and set name
    if (name == null || name.isEmpty()) {
      this.name = "unknown EV";
    }else{
      this.name = name;
    }
    // Clamp battery size
    if (batterySize > 150) {
      this.batterySize = 150;
    }else if(batterySize < 10){
      this.batterySize = 10;
    }else{
      this.batterySize = batterySize;
    }
    // Clamp state of charge
    setStateOfCharge(stateOfCharge);
    // Clamp default efficiency
    if(defaultEfficiency > 4.5){
      this.defaultEfficiency = 4.5;
    }else if(defaultEfficiency < 0.5){
      this.defaultEfficiency = 0.5;
    }else{
      this.defaultEfficiency = defaultEfficiency;
    }
    // Initialize current efficiency
    this.currentEfficiency = this.defaultEfficiency;
  }
  /**
   * Returns the current efficiency of the EV.
   *
   * @return current efficiency
   */
  public double getEfficiency() {return this.currentEfficiency;}
  /**
   * Returns the battery size.
   *
   * @return battery size in kWh
   */
  public double getBatterySize() {return this.batterySize;}

  /**
   * Returns the current state of charge.
   *
   * @return state of charge as a decimal
   */
  public double getStateOfCharge() {return this.stateOfCharge;}
  /**
   * Returns the name of the EV.
   *
   * @return EV name
   */
  public String getName() {return this.name;}

  /**
   * Updates the state of charge.
   *
   * @param newStateOfCharge new state of charge value
   */
  public void setStateOfCharge(double newStateOfCharge) {
    if (newStateOfCharge > 1) {
      this.stateOfCharge = 1;
    }else if(newStateOfCharge  < 0.15){
      this.stateOfCharge = 0.15;
    }else{
      this.stateOfCharge = newStateOfCharge ;
    }
  }
  /**
   * Calculates the estimated driving range.
   *
   * @return estimated range
   */
  public double range(){
    return this.currentEfficiency * this.stateOfCharge * this.batterySize;
  }
  /**
   * Updates the current efficiency based on the current temperature.
   *
   * @param currentTemp temperature in Fahrenheit
   */
  public void updateEfficiency(double currentTemp){
    if (currentTemp > 77.0) {
      this.currentEfficiency = 0.85 * this.defaultEfficiency;
    } else if (currentTemp >= 65.0) {
      this.currentEfficiency = this.defaultEfficiency;
    } else {
      double degreesBelow = 65.0 - currentTemp;
      double reduction = Math.min(degreesBelow, 50.0);
      this.currentEfficiency = (100.0 - reduction) / 100.0 * this.defaultEfficiency;
    }
  }
  /**
   * Returns a string representation of this ElectricVehicle.
   * <p>
   * The returned string includes the vehicle name, the current state of charge
   * expressed as a percentage (with one decimal place), and the estimated range
   * in miles (with one decimal place).
   * </p>
   * <p>
   * Format:
   * Name SOC: XX.X% Range (miles): YY.Y
   * </p>
   *
   * @return a formatted string describing the EV
   */
  @Override
  public String toString(){
    DecimalFormat df = new DecimalFormat("0.0");
    double socPercentage = this.stateOfCharge * 100;
    double range = this.range();
    return this.name + " SOC: " + df.format(socPercentage)
        + "% Range (miles): " + df.format(range);
  }
}
