import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {
  @Test
  void testMovement() {
    Queen queen = new Queen(Color.BLACK, 3, 3);
    // test move straightforward
    assertTrue(queen.canMove(3, 0));
    assertTrue(queen.canMove(7, 3));

    // test move diagonally
    assertTrue(queen.canMove(0, 0));
    assertTrue(queen.canMove(6, 6));

    // test Queen can not move like Bishop
    assertFalse(queen.canMove(5, 4), "Queen cannot move like a Knight");
  }

  @Test
  void testKill() {
    Queen queen = new Queen(Color.WHITE, 0, 0);
    ChessPiece enemy = new Knight(Color.BLACK, 7, 7);
    assertTrue(queen.canKill(enemy), "Queen should kill across the whole board diagonally");
  }
}
