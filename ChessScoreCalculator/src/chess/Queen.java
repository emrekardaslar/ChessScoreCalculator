package chess;

public class Queen extends PieceBase implements Piece {
	public Queen(String color, int row, int column) {
		super(color, row, column);
		//Score is set to 9
		this.score = 9;
	}

	@Override
	public void checkMoves() {
		//Queen can move freely diagonally and in any direction (left, right, up, down)
		//Moves in each diagonal and direction gets checked
		int MAXLENGTH = 8;
		
		//Up-right diagonal
		int r=y-1;
		int c=x+1;
		while (r>=0 && c < MAXLENGTH) {
			if (!Table.getInstance().isOpponent(r, c, color)) 
				if (Table.getInstance().getPieces().get(r).get(c) != null) 
					break;
								
			//Break if threatening a piece
			if(checkPath(r, c))
				break;
			
			r--;
			c++;
		}
		
		//Down-right diagonal
		r = y+1;
		c = x+1;
		while (r<MAXLENGTH && c < MAXLENGTH) {
			if (!Table.getInstance().isOpponent(r, c, color)) 
				if (Table.getInstance().getPieces().get(r).get(c) != null) 
					break;
			
			//Break if threatening a piece				
			if(checkPath(r, c))
				break;
			
			r++;
			c++;
		}
			
		//Up-left diagonal
		r = y-1;
		c = x-1;
		while (r>=0 && c >= 0) {
			if (!Table.getInstance().isOpponent(r, c, color)) 
				if (Table.getInstance().getPieces().get(r).get(c) != null) 
					break;
								
			//Break if threatening a piece 
			if(checkPath(r, c))
				break;
			
			r--;
			c--;
		}
		
		//Down-left diagonal
		r = y+1;
		c = x-1;
		
		while (r<MAXLENGTH && c >= 0) {
			if (!Table.getInstance().isOpponent(r, c, color)) 
				if (Table.getInstance().getPieces().get(r).get(c) != null) 
					break;
								
			//Break if threatening a piece
			if(checkPath(r, c))
				break;
			
			r++;
			c--;
		}

		//Up
		for (int row=y-1; row>=0; row--) {	
			if (!Table.getInstance().isOpponent(row, x, color)) 
				if (Table.getInstance().getPieces().get(row).get(x) != null) 
					break;
			
			 //Break if threatening a piece
			 if(checkPath(row, x))
				break;
		}
		
		//Down
		for (int row=y+1; row<MAXLENGTH; row++) {
			if (!Table.getInstance().isOpponent(row, x, color)) 
				if (Table.getInstance().getPieces().get(row).get(x) != null) 
					break;
			
			//Break if threatening a piece	
			if(checkPath(row, x))
				break;
		}
		
		//Right
		for (int column=x+1; column<MAXLENGTH; column++) {
			if (!Table.getInstance().isOpponent(y, column, color)) 
				if (Table.getInstance().getPieces().get(y).get(column) != null) 
					break;
				
			//Break if threatening a piece
			if(checkPath(y, column))
				break;
		}
		
		//Left
		for (int column=x-1; column>=0; column--) {
			if (!Table.getInstance().isOpponent(y, column, color)) 
				if (Table.getInstance().getPieces().get(y).get(column) != null) 
					break;
				
			//Break if threatening a piece
			if(checkPath(y, column))
				break;
		}
	}
	
	//Checks if an opponent is threatened in that particular path
	//If exists, there is no need to check moves for that particular path
	public boolean checkPath(int row, int column) {
		if (Table.getInstance().isOpponent(row, column, color)) {
			if (!Table.getInstance().getPieces().get(row).get(column).isUnderThreat()) {
				Table.getInstance().getPieces().get(row).get(column).setUnderThreat(true);
				Table.getInstance().getPieces().get(row).get(column).halfScore();
				
				this.logThreat(row, column);
			}			
			return true;	
		}		
		return false;						
	}	
}
