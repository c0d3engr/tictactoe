import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	
	/* This TicTacToe program is going to be entirely in the console. A game-board of symbols will be printed out. 
	A player enters a number on the keyboard. It will place the X and the O to the preferred position.
	An artificial intelligence computer player will randomly play his position. 
	The game will loop until someone wins or loses.
	*/ 
	public static void main(String[] args) {
		//Main() here.
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, 
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '},
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '}};
		
		printGameBoard(gameBoard); // This method will initialize the application by printing a 2D TicTacToe game board.
		
		Scanner scan = new Scanner(System.in); // Imported Scanner from java.util. This will get input from the user.
		
		while(true) {
			System.out.println("Enter your placement (1-9):");
			int playerPos = scan.nextInt();
			
			// System.out.println(pos); // This will print on screen the number position selected by the player.
			
			placePiece(gameBoard, playerPos, "player"); // This method will place piece for player replacing integer input into 'X' char symbol.
			
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			placePiece(gameBoard, cpuPos, "cpu");
			
			printGameBoard(gameBoard); // This method will initialize the application by printing a 2D TicTacToe game board.
				
		}
		
		
	}

	
	
	
	//=============================================================================//
	//=========All methods to run the TicTacToe application has listed below.======//
	//=============================================================================//

	
	// This method will initialize the application by printing a 2D TicTacToe game board.
	public static void printGameBoard(char[][] gameBoard) {
		for (char [] row: gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();	
		}	
	}
	
	
	// This swtch-case method will convert each position or placement from integer input to 'X'.
	public static void placePiece(char[][] gameBoard, int pos, String user) {
		
		char symbol = ' ';
		
		if (user.equals("player")) {
			symbol = 'X';
		}else if (user.equals("cpu")) {
			symbol = 'O';
		}
		
		switch (pos) { 					
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
			default:
				break;
			} }
	
	
	//This method will
	
	
	//This method will
	
	
	//This method will
	

	//This method will
	
	
	
}
