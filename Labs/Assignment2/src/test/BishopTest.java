import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {
  @Test
  void testMovement() {
    Bishop bishop = new Bishop(Color.WHITE, 4, 4);
    assertTrue(bishop.canMove(7, 7), "Should move diagonally up-right");
    assertTrue(bishop.canMove(1, 1), "Should move diagonally down-left");
    assertTrue(bishop.canMove(6, 2), "Should move diagonally up-left");

    assertFalse(bishop.canMove(4, 5), "Should not move horizontally");
    assertFalse(bishop.canMove(5, 4), "Should not move vertically");
  }

  @Test
  void testInvalidPosition() {
    assertThrows(IllegalArgumentException.class, () -> new Bishop(Color.BLACK, 8, 2));
  }
}
