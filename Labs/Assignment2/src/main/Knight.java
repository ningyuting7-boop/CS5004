/**
 * Represents a Knight piece. Moves in an 'L' pattern:
 * two squares horizontally and one square vertically, or vice versa.
 */
public class Knight extends ChessPiece{
  public Knight(Color color, int row, int col){
    super(color, row, col);
  }

  @Override
  public boolean canMove(int targetRow, int targetCol){
    if(!validateLocation(targetRow, targetCol)){
      return false;
    }
    return Math.abs(this.row - targetRow) == 2 && Math.abs(this.col - targetCol) == 1
        || Math.abs(this.row - targetRow) == 1 && Math.abs(this.col - targetCol) == 2;
  }
}
