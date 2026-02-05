/**
 * The contract for any chess piece.
 * Defines the basic movement and identification capabilities.
 */
public interface ChessPieceContract {
  /** @return the current row of the piece (0-7). */
  int getRow();

  /** @return the current column of the piece (0-7). */
  int getColumn();

  /** @return the color of the piece. */
  Color getColor();

  /**
   * Determines if the piece can move to a specific cell.
   * @param targetRow the row to move to.
   * @param targetCol the column to move to.
   * @return true if the move is valid, false otherwise.
   */
  boolean canMove(int targetRow, int targetCol);

  /**
   * Determines if the piece can capture (kill) another piece.
   * @param piece the opponent's piece to be captured.
   * @return true if the capture is possible, false otherwise.
   */
  boolean canKill(ChessPiece piece);
}
