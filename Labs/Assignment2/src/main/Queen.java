/**
 * Represents a Queen piece. Can move any number of squares in any direction.
 */
public class Queen extends ChessPiece {
  public Queen(Color color, int row, int col){
    super(color, row, col);
  }

  @Override
  public boolean canMove(int targetRow, int targetCol){
    if(!validateLocation(targetRow, targetCol)){
      return false;
    }
    return this.col == targetCol || this.row == targetRow
        || Math.abs(this.row - targetRow) == Math.abs(this.col - targetCol);
  }
}
