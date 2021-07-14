package chess;

import java.util.ArrayList;

public class Table {
	private ArrayList<ArrayList<Piece>> pieces;
	private static Table instance;
	private float whiteScore=0;
	private float blackScore=0;
	
	//Table uses Singleton pattern, the operations are made through the instance 
	public static Table getInstance() {
        if (instance == null) {
            instance = new Table();
        }
        return instance;
    }
	//Checks if the piece at given location and color is opponent or not
	public boolean isOpponent(int row, int column, String color) {	
		//Return false if the grid is empty
		if (instance.pieces.get(row).get(column) == null)
			return false;
		
		if (!instance.pieces.get(row).get(column).getColor().equals(color))
			return true;
		
		else
			return false;
	}
	
	//Check every move of existing pieces
	public void checkEveryMove() {
		for (int row=0; row<instance.pieces.size();row++) {
			for (int column=0; column<instance.pieces.get(row).size(); column++) {
				if (instance.pieces.get(row).get(column) != null)
					instance.pieces.get(row).get(column).checkMoves();
			}
		}
	}
	
	//Calculate scores for both players
	public void calculatePoints() {
		int MAXLENGTH = 8;
		for (int row=0; row<MAXLENGTH; row++)
			for (int column=0; column<MAXLENGTH; column++) {
				try {
					float pieceScore = pieces.get(row).get(column).getScore();
					if (pieces.get(row).get(column).getColor().equals("b")) {
						instance.whiteScore+=pieceScore;
					}
					else if (pieces.get(row).get(column).getColor().equals("s")) {
						instance.blackScore+=pieceScore;
					}
				}
				catch(Exception e) {
					//Empty grids
				}
			}
	}
	
	public float getWhiteScore() {
		return whiteScore;
	}

	public void setWhiteScore(float whiteScore) {
		this.whiteScore = whiteScore;
	}

	public float getBlackScore() {
		return blackScore;
	}

	public void setBlackScore(float blackScore) {
		this.blackScore = blackScore;
	}


	public ArrayList<ArrayList<Piece>> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<ArrayList<Piece>> pieces) {
		instance.pieces = pieces;
	}	
}
