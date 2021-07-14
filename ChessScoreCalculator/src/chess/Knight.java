package chess;

public class Knight extends PieceBase implements Piece{	
	public Knight(String color, int row, int column) {
		super(color, row, column);
		//Score is set to 3
		this.score = 3;
	}
	
	@Override
	public void checkMoves() {
		//Knight moves two squares vertically and one square horizontally, or two squares horizontally and one square vertically
		//Can have maximum 8 moves, the method checks those moves
		
		if(checkBoundries(y+1, x+2)) {
			checkPath(y+1, x+2);
		}
		
		if(checkBoundries(y+1, x-2)) {
			checkPath(y+1, x-2);
		}
		
		if(checkBoundries(y-1, x+2)) {
			checkPath(y-1, x+2);
		}
		
		if(checkBoundries(y-1, x-2)) {
			checkPath(y-1, x-2);
		}
		
		if(checkBoundries(y+2, x+1)) {
			checkPath(y+2, x+1);
		}
		
		if(checkBoundries(y+2, x-1)) {
			checkPath(y+2, x-1);
		}
		
		if(checkBoundries(y-2, x+1)) {
			checkPath(y-2, x+1);
		}
		
		if(checkBoundries(y-2, x-1)) {
			checkPath(y-2, x-1);
		}
		
	}



	public void checkPath(int row, int column) {
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
