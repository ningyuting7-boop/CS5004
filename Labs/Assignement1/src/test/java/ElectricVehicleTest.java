import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ElectricVehicleTest {
  private ElectricVehicle vehicle1;
  private ElectricVehicle vehicle2;
  private ElectricVehicle vehicle3;
  @BeforeEach
  void setUp(){
    this.vehicle1 = new ElectricVehicle("Tesla", 100, 0.8, 3);
    this.vehicle2 = new ElectricVehicle("", 200, 0.1, 5);
    this.vehicle3 = new ElectricVehicle("BWM", 80, 0.5, 2.555555);
  }
  @Test
  void TestConstructorAndGetters(){
    // without clamping
    assertEquals("Tesla", vehicle1.getName());
    assertEquals(80, vehicle3.getBatterySize(), 1e-6);
    assertEquals(0.8, vehicle1.getStateOfCharge(), 1e-6);
    assertEquals(2.555555, vehicle3.getEfficiency(), 1e-6);
    // with clamping
    assertEquals("unknown EV", vehicle2.getName());
    assertEquals(150, vehicle2.getBatterySize(), 1e-6);
    assertEquals(0.15, vehicle2.getStateOfCharge(), 1e-6);
    assertEquals(4.5, vehicle2.getEfficiency(), 1e-6);
  }
  @Test
  void TestSetters(){
    // invalid state of charge
    vehicle1.setStateOfCharge(-0.1);
    assertEquals(0.15, vehicle1.getStateOfCharge(), 1e-6);
    // valid state of charge (0.15 - 1)
    vehicle1.setStateOfCharge(0.5);
    assertEquals(0.5, vehicle1.getStateOfCharge(), 1e-6);
  }
  @Test
  void TestRange(){
    assertEquals(240, vehicle1.range(), 1e-6);
    assertEquals(102.2222, vehicle3.range(), 1e-6);
  }
  @Test
  void TestUpdateEfficiency(){
    // temp > 77
    vehicle1.updateEfficiency(100);
    assertEquals(2.55, vehicle1.getEfficiency(), 1e-6);
    // 65 <= temp <= 77
    vehicle1.updateEfficiency(70.12345);
    assertEquals(3, vehicle1.getEfficiency(), 1e-6);
    // temp < 65
    vehicle3.updateEfficiency(45.678);
    assertEquals(2.0617706, vehicle3.getEfficiency(), 1e-6);
    // temp is too low
    vehicle3.updateEfficiency(5);
    assertEquals(1.2777775, vehicle3.getEfficiency(), 1e-6);
  }
  @Test
  void TestToString(){
    String reString = vehicle1.toString();
    assertTrue(reString.contains("Tesla"));
    assertTrue(reString.contains("240.0"));
    assertTrue(reString.contains("80.0%"));
  }
}
