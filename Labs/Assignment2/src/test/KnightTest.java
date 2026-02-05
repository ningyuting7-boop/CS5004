import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
  @Test
  void testLShapes() {
    Knight knight = new Knight(Color.BLACK, 4, 4);
    // Test L shape in any direction
    assertTrue(knight.canMove(6, 5));
    assertTrue(knight.canMove(6, 3));
    assertTrue(knight.canMove(2, 5));
    assertTrue(knight.canMove(2, 3));
    assertTrue(knight.canMove(5, 6));
    assertTrue(knight.canMove(5, 2));
    assertTrue(knight.canMove(3, 6));
    assertTrue(knight.canMove(3, 2));
  }

  @Test
  void testInvalidKnightMoves() {
    Knight knight = new Knight(Color.WHITE, 0, 0);
    assertFalse(knight.canMove(1, 1), "Cannot move diagonally");
    assertFalse(knight.canMove(0, 2), "Cannot move strictly horizontally");
  }
}
