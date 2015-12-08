import java.util.Scanner;

public class SeaChess {
	
	public static int[] enterCoordinates(int row, int col){
		Scanner sc = new Scanner(System.in);
		while(row<0 || row >2 || col<0 || col>2){
			System.out.println("Please enter correct coordinates for position of your simbol");
			row = sc.nextInt();
			col = sc.nextInt();
		}
		return new int[]{row,col};
	}
	public static void	freePosition(char[][] board, int row, int col, int counter){
		Scanner sc = new Scanner(System.in);
		int[] array =  enterCoordinates(row, col);
		row = array[0];
		col = array[1];
		while(board[row][col] == 'X' || board[row][col] == 'O'){
				System.out.println("Position with coordinates " + row + ", " +col + " is not free. "
						+ "Please enter coordinates of free position");
				row = sc.nextInt();
				col = sc.nextInt();
				array = enterCoordinates(row, col);
				row = array[0];
				col = array[1];
			}
		
		if(counter%2 == 1){
			board[row][col] = 'X';
		}
		else{
			board[row][col] = 'O';
		}
	}

	public static void main(String[] args) {
		char[][]board = new char[3][3];
		boolean winner = false;
		Scanner sc = new Scanner(System.in);
		int counter = 1;
		while(counter<=9){
			if(counter%2 == 1){
				System.out.println("Player 1: Enter coordinates for you symbol:");
				int row = sc.nextInt();
				int col = sc.nextInt();
				freePosition(board, row, col, counter);
			}
			if(counter%2 == 0){
				System.out.println("Player 2: Enter coordinates for your symbol:");
				int row = sc.nextInt();
				int col = sc.nextInt();
				freePosition(board, row, col, counter);
			}
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			
			
	}
	}
}
