import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
  @Test
  void testMovement() {
    King king = new King(Color.WHITE, 4, 4);
    // move one step in any direction
    assertTrue(king.canMove(5, 4)); // up
    assertTrue(king.canMove(3, 4)); // down
    assertTrue(king.canMove(4, 5)); // right
    assertTrue(king.canMove(4, 3)); // left
    assertTrue(king.canMove(5, 5)); // upper right

    // test invalid movement : move two steps
    assertFalse(king.canMove(6, 4), "King cannot move two squares");
    assertFalse(king.canMove(6, 6), "King cannot move two squares diagonally");
  }

  @Test
  void testKill() {
    King king = new King(Color.BLACK, 0, 0);
    ChessPiece enemy = new Pawn(Color.WHITE, 1, 1);
    assertTrue(king.canKill(enemy), "King can kill adjacent enemy");
  }
}