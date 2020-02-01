package chess;

import boardgame.Position;

public class ChessPosition {

	// Controls the entry of part positions
	
	private char column;
	private int row;
	
	
	public ChessPosition(char column, int row) {
		// Check security (Size) of rows and colums in the board.
		if(column < 'a' || column > 'h'  || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8");
		}
		this.column = column;
		this.row = row;
	}


	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	/*
	 *	After giving a position of letters and numbers 
     *  in the matrix I convert to indexes.
	 */
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}

	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow() );
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
	
}
