import java.util.Scanner;

public class HorseChessMovement {
	public static void horseMovement(char[][] array, int row, int col){
		if(row<0 || row>=array.length){
			return;
		}
		if(col<0 || col>=array[0].length){
			return;
		}
		if(array[row][col] == '*' ){
			return;
		}

     	array[row][col] = '*';
		horseMovement(array, row-2, col+1);
		horseMovement(array, row-2, col-1);
		horseMovement(array, row-1, col-2);
		horseMovement(array, row+1, col-2);
		horseMovement(array, row+2, col-1);
		horseMovement(array, row+2, col+1);
		//horseMovement(array, row+1, col+2);
		//horseMovement(array, row-1, col+2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dimensions of array (a>0, b>0):");
		int a = sc.nextInt();
		int b = sc.nextInt();
		while(a<=0 || b<=0){
			System.out.println("Please enter valid values for dimensions");
			a = sc.nextInt();
			b = sc.nextInt();
		}
		
		char[][]array = new char[a][b];
		System.out.println("Enter a coordinates of statring point for the horse");
		System.out.print("Row:");
		int row = sc.nextInt();
		System.out.print("Col:");
		int col = sc.nextInt();
		horseMovement(array, row, col);
		array[row][col] = 'S';
		System.out.println("With letter \"S\" we mark start position of our horse");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	
	}
}
