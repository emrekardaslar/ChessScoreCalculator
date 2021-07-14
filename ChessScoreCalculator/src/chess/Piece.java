package chess;

//Interface for Piece
public interface Piece {
	//Methods that every piece must have
	void halfScore();
	String getColor();
	int getX();
	int getY();
	float getScore();
	void checkMoves();
	boolean isUnderThreat();
	void setUnderThreat(boolean underThreat);
}
