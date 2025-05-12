import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/* This TicTacToe program is going to be entirely in the console. A game-board of symbols will be printed out. 
A player enters a number on the keyboard. It will place the X and the O to the preferred position.
An artificial intelligence computer player will randomly play his position. 
The game will loop until someone wins or loses.
*/

public class TicTacToe { 
	
	//This ArrayList is global so that all the methods know it, static so there's no need to make an object for every access.
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		//Main() here.
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, 
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '},
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '}};
		
		printGameBoard(gameBoard); // This method will initialize the application by printing a 2D TicTacToe game board.
		
		while(true) {
			Scanner scan = new Scanner(System.in); // Imported Scanner from java.util. This will get input from the user.
			System.out.println("Enter your placement (1-9):");
			int playerPos = scan.nextInt();
			while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
				System.out.println("Position taken! Enter a correct position:");
				playerPos = scan.nextInt();
			}
			
			placePiece(gameBoard, playerPos, "player"); // This method will place piece for player replacing integer input into 'X' char symbol.
			
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
				cpuPos = rand.nextInt(9) + 1;
			}
			
			placePiece(gameBoard, cpuPos, "cpu");
			
			printGameBoard(gameBoard); // This method will initialize the application by printing a 2D TicTacToe game board.
			
			String result = checkWinner();
			System.out.println(result);
		}
		
		
	}

	

	//=============================================================================//
	//=========All methods to run the TicTacToe application listed below.======//
	//=============================================================================//

	
	// no1 This method will initialize the application by printing a 2D TicTacToe game board.
	public static void printGameBoard(char[][] gameBoard) {
		for (char [] row: gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();	
		}	
	}
	
	
	// no2 This swtch-case method will convert each position or placement from integer input to 'X'.
	public static void placePiece(char[][] gameBoard, int pos, String user) {
		
		char symbol = ' ';
		
		if (user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		}else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(pos);
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
	
	
	// no3 This method will check a winner. 
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning) {
			if (playerPositions.containsAll(l)){
				return "Congratulations you won!";
			}else if(cpuPositions.containsAll(l)){
				return "CPU wins! Sorry :(";
			}else if(playerPositions.size() + cpuPositions.size() == 9) {
				return "CAT!";
			}
		}
		
		return "";
	}
	
	
	// no4 This method will..
	
	
	// no5 This method will..
	

	// no6 This method will..
	
	
	
}
