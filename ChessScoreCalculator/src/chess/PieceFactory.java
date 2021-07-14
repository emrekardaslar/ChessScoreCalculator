package chess;

public class PieceFactory {
	//The pieces get created using Factory Pattern
	//The PieceFactory uses type, color and location of pieces to create
	public static Piece getPiece(String type, String color, int row, int column) {
		switch(type) {
			case "k":
				return new Rook(color, row, column);
			case "a":
				return new Knight(color, row, column); 
			case "f":
				return new Bishop(color, row, column);
			case "v":
				return new Queen(color, row, column);
			case "s":
				return new King(color, row, column);
			case "p":
				return new Pawn(color, row, column);
		}	
		//Return null if the grid is empty
		return null;
	}
}
