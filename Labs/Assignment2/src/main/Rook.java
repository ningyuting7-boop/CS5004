/**
 * Represents a Rook piece. Can move any number of squares horizontally or vertically.
 */
public class Rook extends ChessPiece{

  public Rook(Color color, int row, int col){
    super(color, row, col);
  }

  @Override
  public boolean canMove(int targetRow, int targetCol){
    if (!this.validateLocation(targetRow, targetCol)){
      return false;
    }
    return this.row == targetRow || this.col == targetCol;
  }
}

