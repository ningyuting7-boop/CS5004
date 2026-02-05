/**
 * Represents a Pawn chess piece.
 * Pawns move forward one square, but capture diagonally.
 * They have a special option to move two squares forward from their starting row.
 */
public class Pawn extends ChessPiece{
  /**
   * Constructs a Pawn and validates its position.
   * * @param color the color of the piece.
   * @param row   the initial row (0-7).
   * @param col   the initial column (0-7).
   * @throws IllegalArgumentException if the position is invalid or
   * if the pawn is placed on its own royal row (Note 2).
   */
  public Pawn(Color color, int row, int col){
    super(color, row, col);
    // Note 2: Constraint for royal rows
    if ((color == Color.WHITE && row == 0) || (color == Color.BLACK && row == 7)) {
      throw new IllegalArgumentException("Pawns cannot be placed on their respective royal rows.");
    }
  }

  @Override
  public boolean canMove(int targetRow, int targetCol){
    if(!validateLocation(targetRow, targetCol)){
      return false;
    }
    // Must stay in the same column
    if (targetCol != this.col) {return false;}

    int direction = (this.color == Color.WHITE) ? 1 : -1;
    int startRow = (this.color == Color.WHITE) ? 1 : 6;

    // One step forward
    if (targetRow - this.row == direction) {return true;}

    // Two steps forward from start row
    return this.row == startRow && targetRow - this.row == direction * 2;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece == null || this.color == piece.getColor()) {
      return false;
    }
    // must be in the front of original cell
    int direction = (this.color == Color.WHITE) ? 1 : -1;
    if (piece.getRow() - this.row != direction) {
      return false;
    }
    return Math.abs(piece.getColumn() - this.col) == 1;
  }
}
