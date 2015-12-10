public class Zadacha3 {

	static void horseChess(char[][] table, int row, int col){
		
		if(table[row][col] == 'H'){
			return;
		}
		
		if(row < 0 || row > table.length-1){
			return;
		}
		if(col < 0 || col > table[0].length-1){
			return;
		}
		

		
		if(table[row][col] == '\u0000'){
			
			table[row][col] = 'H';
			
		}
		
	
		
		horseChess(table,  row-2,  col-1);
		horseChess(table,  row-2,  col+1);
		horseChess(table,  row-1,  col-2);
		horseChess(table,  row-1,  col+2);
		horseChess(table,  row+1,  col-2);
		horseChess(table,  row+1,  col+2);
		horseChess(table,  row+2,  col-1);
		horseChess(table,  row+2,  col+1);
	}
}
