package chess;

//Abstract class for each piece, contains common method implementations
public abstract class PieceBase implements Piece{
	protected int x;
	protected int y;
	protected String color;
	protected float score;
	protected boolean underThreat;
	
	//Constructor: Pieces get created by their color and location
	public PieceBase(String color, int row, int column) {
		this.color = color;
		this.x = column;
		this.y = row;
		this.score = 0;
		this.underThreat = false;
	}
	
	@Override
	public void halfScore() {
		this.score /= 2;
	}
	
	@Override
	public float getScore() {
		return this.score;
	}

	@Override
	public void checkMoves() {
		
	}
	//Check if the given location is inside the table
	public boolean checkBoundries(int row, int column) {
		int MAXLENGTH = 8;
		if (row>=0 && row<MAXLENGTH && column>=0 && column<MAXLENGTH)
			return true;
		return false;
	}
	
	//To see the threats occured by the piece
	public void logThreat(int row, int column) {
		System.out.println(
				this.color + " colored " + this.getClass().getSimpleName()+ " (" + this.y + "," + this.x + ") is threatting " + 
				Table.getInstance().getPieces().get(row).get(column).getColor() + " colored " +
				Table.getInstance().getPieces().get(row).get(column).getClass().getSimpleName() + " (" + row + ","+ column + ")"
			);
	}
	
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isUnderThreat() {
		return underThreat;
	}

	public void setUnderThreat(boolean underThreat) {
		this.underThreat = underThreat;
	}

	public void setScore(float score) {
		this.score = score;
	}	
}
