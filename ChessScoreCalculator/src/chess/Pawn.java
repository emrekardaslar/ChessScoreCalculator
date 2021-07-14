package chess;

public class Pawn extends PieceBase implements Piece {
	public Pawn(String color, int row, int column) {
		super(color, row, column);
		//Score is set to 1
		this.score = 1;
	}

	@Override
	public void checkMoves() {
		//Pawns can threat diagonally (1-unit) but the direction is important
		//If the piece is white, the direction must be upwards
		if (this.color.equals("b")) {
			
			if (checkBoundries(y-1, x+1)) {
				checkPath(y-1, x+1);
			}

			if (checkBoundries(y-1, x-1)) {
				checkPath(y-1, x-1);
			}
		}
		//If the piece is black, the direction must be downwards
		if (this.color.equals("s")) {
			if (checkBoundries(y+1, x+1)) {
				checkPath(y+1, x+1);
			}
			
			if (checkBoundries(y+1, x-1)) {
				checkPath(y+1, x-1);
			}
		}		
	}

	private void checkPath(int row, int column) {	
		//If the piece is opponent
		if (Table.getInstance().isOpponent(row, column, color)) {
			//Threat the given piece and half its score
			if (!Table.getInstance().getPieces().get(row).get(column).isUnderThreat()) {
				Table.getInstance().getPieces().get(row).get(column).setUnderThreat(true);
				Table.getInstance().getPieces().get(row).get(column).halfScore();
				
				this.logThreat(row, column);
			}
		}	
	}
}
