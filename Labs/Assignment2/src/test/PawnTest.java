import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTest{
  @Test
  void TestIllegalArgumentException(){
    // White pawn on row 0
    assertThrows(IllegalArgumentException.class, () -> {
      new Pawn(Color.WHITE, 0, 3);
    });
    // Black pawn on row 7
    assertThrows(IllegalArgumentException.class, () -> {
      new Pawn(Color.BLACK, 7, 3);
    });
  }

  @Test
  void testWhitePawnMovement() {
    Pawn p = new Pawn(Color.WHITE, 1, 3);
    assertTrue(p.canMove(2, 3), "White pawn should move 1 step forward");
    assertTrue(p.canMove(3, 3), "White pawn should move 2 steps from row 1");
    assertFalse(p.canMove(4, 3), "White pawn cannot move 3 steps");

    Pawn p2 = new Pawn(Color.WHITE, 2, 3);
    assertFalse(p2.canMove(4, 3), "White pawn cannot move 2 steps if not on row 1");
  }

  @Test
  void testBlackPawnMovement() {
    Pawn p = new Pawn(Color.BLACK, 6, 3);
    assertTrue(p.canMove(5, 3), "Black pawn should move 1 step forward");
    assertTrue(p.canMove(4, 3), "Black pawn should move 2 steps from row 1");
    assertFalse(p.canMove(3, 3), "Black pawn cannot move 3 steps");

    Pawn p2 = new Pawn(Color.BLACK, 3, 3);
    assertFalse(p2.canMove(1, 3), "Black pawn cannot move 2 steps if not on row 1");
  }

  @Test
  void testPawnCapture() {
    Pawn whitePawn = new Pawn(Color.WHITE, 3, 3);
    ChessPiece blackEnemy = new Rook(Color.BLACK, 4, 4);
    ChessPiece blackTooFar = new Rook(Color.BLACK, 5, 5);

    assertTrue(whitePawn.canKill(blackEnemy), "Should kill diagonally one step away");
    assertFalse(whitePawn.canKill(blackTooFar), "Should not kill diagonally two steps away");

    // Cannot kill straight ahead
    ChessPiece enemyInFront = new Rook(Color.BLACK, 4, 3);
    assertFalse(whitePawn.canKill(enemyInFront), "Pawn cannot kill straight ahead");
  }

}
