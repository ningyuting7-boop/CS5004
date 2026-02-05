/**
 * Represents a King piece. Can move one square in any direction.
 */
public class King extends ChessPiece{
  public King(Color color, int row, int col){
    super(color, row, col);
  }

  @Override
  public boolean canMove(int targetRow, int targetCol){
    if(!validateLocation(targetRow, targetCol)){
      return false;
    }
    return Math.abs(this.row - targetRow) <= 1 && Math.abs(this.col - targetCol) <= 1;
  }
}
