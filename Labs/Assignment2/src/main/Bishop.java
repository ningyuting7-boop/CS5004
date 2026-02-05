/**
 * Represents a Bishop piece. Can move any number of squares diagonally.
 */
public class Bishop extends ChessPiece{

  public Bishop(Color color, int row, int col){
    super(color, row, col);
  }

  @Override
  public boolean canMove(int targetRow, int targetCol){
    if(!validateLocation(targetRow, targetCol)){
      return false;
    }
    return Math.abs(this.row - targetRow) == Math.abs(this.col - targetCol);
  }
}
