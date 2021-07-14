# ChessScoreCalculator
Chess score calculation for both sides, according to the pieces on the table.

# Installation:
Option 1- If you are using an IDE, import the project and run the program through IDE. Put the text files under the project folder.
You can change the loaded file inside the Main class. IDE will compile source files.

Option 2- To compile the package using terminal, change directory to the src folder and run
### `javac ./chess/*`

To run the application, change directory to the src folder, put the text files under src folder and run: 

### `java chess.Main`

Default file name to load is "board1.txt", to run desired file instead of the default option, run: 
### `java chess.Main filename.txt`


# Design:

Factory design pattern is used to create pieces. Abstraction is provided by the Piece interface and PieceBase abstract class.
Piece interface has the common must-have method declarations and the PieceBase has the implementations of the common methods.
Whole pieces implement Piece interface and extend PieceBase. Using that structure minimizes duplicate code. 
PieceFactory class creates pieces according to their type, color and location. Each piece check if they are threating another piece or not.
Singleton pattern is used to evaluate the scores, Table class has an instance and operations on the table by pieces made through that instance. Table class holds
the piece data and calls move check method of each piece and adds scores to both sides.

Note: Threats made by Queen, Pawn and Knight are evaluated.
