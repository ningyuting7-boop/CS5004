import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains all the unit tests for triangle
 */
public class TriangleTest {
  Triangle t1, t2, t3;

  @BeforeEach
  public void setUp(){
    t1 = new Triangle(0, 0 ,3, 4, 6, 0);
    t2 = new Triangle(0, 0, 0, 8, 6, 0);
    t3 = new Triangle(1, 1, 1, 2, 1, 3);
  }

  @Test
  public void testThrowExceptions(){
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(0, 0, 1, 2, 1, 2);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(0, 0, 0, 0, 1, 2);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(1, 2, 1, 2, 1, 2);
    });
  }

  @Test
  public void testPerimeter(){
    assertEquals(16, t1.perimeter(), 0.0001);
    assertEquals(24, t2.perimeter(), 0.0001);
  }

  @Test
  public void testArea(){
    assertEquals(12, t1.area(), 0.0001);
    assertEquals(24, t2.area(), 0.0001);
    assertEquals(0, t3.area(), 0.0001);
  }

  @Test
  public void testResize() {
    Triangle resized = t2.resize(4.0); // area should be 4x
    assertEquals(t2.area() * 4, resized.area(), 0.0001);

    // reference point should remain the same
    assertEquals(0.0, resized.toString().contains("(0.000,0.000)") ? 0.0 : -1.0);
  }

  @Test
  public void testToString(){
    String str1 = t1.toString();
    String str2 = t2.toString();
    assertTrue(str1.contains("reference point (0.000,0.000)"));
    assertTrue(str2.contains("p2 (0.000,8.000)"));
    assertTrue(str2.contains("p3 (6.000,0.000)"));
  }



}
