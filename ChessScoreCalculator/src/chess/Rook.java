package chess;

public class Rook extends PieceBase implements Piece {	
	public Rook(String color, int row, int column) {
		super(color, row, column);
		//Score is set to 5
		this.score = 5;
	}
}
