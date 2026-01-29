import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ShoeTest {
  @Test
  public void testConstructorAndGetters(){
    Shoe shoe = new Shoe(Kind.BOOT, Brand.NIKE, Color.PINK, 6.5);
    assertEquals(Kind.BOOT, shoe.getKind());
    assertEquals(Brand.NIKE, shoe.getBrand());
    assertEquals(Color.PINK, shoe.getColor());
    assertEquals(6.5, shoe.getSize(), 0.001);
  }
  @Test
  public void testToString(){
    Shoe shoe = new Shoe(Kind.SANDAL, Brand.PUMA, Color.BLACK, 12.5);
    assertTrue(shoe.toString().contains("Sandal"));
    assertTrue(shoe.toString().contains("Puma"));
    assertTrue(shoe.toString().contains("Black"));
    assertTrue(shoe.toString().contains("12.5"));
  }

  @Test
  public void testThrowExceptions(){
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      new Shoe(Kind.DRESS, Brand.NIKE, Color.PINK, 7);
    });
    String expected_message = "NIKE does not sell dress shoes.";
    String actual_message = e.getMessage();
    assertTrue(actual_message.contains(expected_message));
  }
}
