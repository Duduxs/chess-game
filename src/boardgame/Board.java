package boardgame;

public class Board {

	// Class board where they are elements of board
	
	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column!");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	
	public Piece piece(int row, int column) {
		if(!positionExists(row,column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	/*Receive the piece on the insert position and test if
     * already exists a piece in position
	 */ 
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		// Check if the position exists
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		// If isn't there a piece in board return null
		if(piece(position) == null) {
			return null;
		}
		// else..
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	/**
	 * See if the part exists in a certain position, 
	 *  making sure that the parts do not leave the range
	 *   of the matrix
	 */
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
	

}
