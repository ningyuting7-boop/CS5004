import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
  @Test
  void testMovement() {
    Rook rook = new Rook(Color.WHITE, 3, 3);
    assertTrue(rook.canMove(3, 7), "Should move horizontally to the end");
    assertTrue(rook.canMove(3, 0), "Should move horizontally to the start");
    assertTrue(rook.canMove(0, 3), "Should move vertically to the bottom");
    assertTrue(rook.canMove(7, 3), "Should move vertically to the top");

    assertFalse(rook.canMove(4, 4), "Should not move diagonally");
    assertFalse(rook.canMove(3, 3), "Should not move to the same spot");
  }

  @Test
  void testKill() {
    Rook rook = new Rook(Color.BLACK, 0, 0);
    ChessPiece enemy = new Rook(Color.WHITE, 0, 5);
    assertTrue(rook.canKill(enemy), "Should kill enemy on the same row");
  }
}
