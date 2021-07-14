package chess;

public class King extends PieceBase implements Piece {	
	public King(String color, int row, int column) {
		super(color, row, column);
		//Score is set to 100
		this.score = 100;
	}
}
