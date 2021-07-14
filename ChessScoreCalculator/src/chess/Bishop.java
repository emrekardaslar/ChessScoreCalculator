package chess;

public class Bishop extends PieceBase implements Piece {	
	public Bishop(String color, int row, int column) {
		super(color, row, column);
		//Score is set to 3
		this.score = 3;
	}
}
