/**
 * Represents an abstract chess piece with common properties and validation.
 * All specific chess pieces (Pawn, King, etc.) must extend this class.
 */
public abstract class ChessPiece implements ChessPieceContract{
  protected final Color color;
  protected final int row;
  protected final int col;

  /**
   * Constructs a ChessPiece and validates its initial position.
   *
   * @param color the color of the piece (BLACK or WHITE).
   * @param row   the initial row position (0-7).
   * @param col   the initial column position (0-7).
   * @throws IllegalArgumentException if the position is out of the 8x8 board bounds.
   */
  public ChessPiece(Color color, int row, int col){
    this.color = color;
    if (row < 0 || row > 7) {
      throw new IllegalArgumentException("Row of board must be 0-7");
    }
    if (col < 0 || col > 7) {
      throw new IllegalArgumentException("Column of board must be 0-7");
    }
    this.row = row;
    this.col = col;
  }


  @Override
  public int getRow() {return this.row;}

  @Override
  public int getColumn() {return this.col;}

  @Override
  public Color getColor() {return this.color;}

  /**
   * Helper method to check if a target location is within board bounds
   * and not the current position.
   *
   * @param targetRow the row to check.
   * @param targetCol the column to check.
   * @return true if the location is valid and different from current, false otherwise.
   */
  public boolean validateLocation(int targetRow, int targetCol){
    // check row, col extend the boundary
    if (targetRow < 0 || targetRow > 7 || targetCol < 0 || targetCol > 7) {
      return false;
    }
    // A piece cannot "move" to its own current position
    if (this.row == targetRow && this.col == targetCol) {
      return false;
    }
    return true;
  }
  /**
   * Default implementation for killing a piece.
   * Most pieces kill using the same logic as their move logic,
   * but only if the target piece is of a different color.
   *
   * @param piece the target piece to kill.
   * @return true if the target piece can be captured.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    return piece != null &&
        this.color != piece.getColor() &&
        this.canMove(piece.getRow(), piece.getColumn());
  }
}
