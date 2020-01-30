package boardgame;

public class Piece {

	// Contains a position of a piece.
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}

	
}
