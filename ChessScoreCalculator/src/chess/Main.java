package chess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//Loads the file, fills the pieces list and returns it
	private static ArrayList<ArrayList<Piece>> loadFile(String fileName) throws FileNotFoundException {
		ArrayList<ArrayList<Piece>> listOfPieces = new ArrayList<ArrayList<Piece>>();
		File file = new File(fileName);
		Scanner s = new Scanner(file);
		int column = 0;
		int row = 0;
		
		while (s.hasNextLine()) {
			ArrayList<Piece> pieces = new ArrayList<Piece>();
			String line = s.nextLine();
			String[] tokens = line.split(" ");
			for (String token: tokens) {
				String[] attributes = token.split("");
				String color = attributes[1];
				String type = attributes[0];	
				//The pieces are created by the PieceFactory
				Piece piece = PieceFactory.getPiece(type, color, row, column);					
				pieces.add(piece);		
				column++;
			}

			row++;
			column=0;
						
			listOfPieces.add(pieces);
		}
		
		s.close();
		
		return listOfPieces;
	}
	
	public static void main(String[] args) { 
		// Default file name unless a command line parameter is given
		String fileName = "board1.txt";
		
		//File name as single argument exist ? 
		if (args.length == 1) {
			fileName = args[0];
		}
		
		System.out.println("Loading file: " + fileName);
			
		try {
			ArrayList<ArrayList<Piece>> listOfPieces = loadFile(fileName);
			
			//The list of pieces gets passed to the Table		
			Table.getInstance().setPieces(listOfPieces);
			//Table checks the moves of the pieces
			Table.getInstance().checkEveryMove();
			//Table calculates total score of each player
			Table.getInstance().calculatePoints();
			
			System.out.println("Black: " + Table.getInstance().getBlackScore());
			System.out.println("White: " + Table.getInstance().getWhiteScore());
			
		} catch (FileNotFoundException e) {
			System.out.println("Cannot read file " + fileName);
		}
	}
}
