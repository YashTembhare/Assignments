
import java.util.Scanner;

public class Sudoku {
	public static void display(int [][] board ){
		for (int i = 0; i<board.length; i++){
			for (int j = 0; j<board.length; j++){
				System.out.print(board[i][j]+ " " );				
			}
			System.out.println();
		}
		
	}
	
	public static void  solveSudoku(int[][] board , int i , int j) {
		if (i==board.length) {
			display(board);
			return ;
		}
		//for next row and column element
		//initially set to (0,0)
		int nexti = 0;
		int nextj = 0 ;
		//if last column element reach for the particular row increase row by +1 and set column to 0
		if(j==board[0].length - 1) {
			nexti = i+1;
			nextj = 0;
		}
		else {
			nexti = i ;
			nextj = j+1;
		}
		// insert element from 1 to 9 in place of 0 and also check number is valid or not
		if(board[i][j] == 0 ) {
			for (int pi = 1; pi<=9;pi++) {
				 if(isValid(board,i,j,pi)== true) {
						board[i][j]=pi;
						solveSudoku(board, nexti, nextj);
						//backtracking
						board[i][j]=0;
					}
				}
			}
		else {
			solveSudoku(board, nexti, nextj);
		}
	}
	//check the number is valid for that position or not by checking these condition
	public static boolean isValid(int[][] board , int x , int y, int val) {
		for (int i = 0; i<board.length;i++) {
			if(board[i][y]==val) {
				return false;
			}			
		}
		for (int j = 0; j<board[0].length;j++) {
			if(board[x][j]==val) {
				return false;
			}			
		}
		//check number is repeat or not in it's 3x3 
		int submatrixi= x/3 *3;
		int submatrixj= y/3 *3;
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				if (board[submatrixi + i][submatrixj +j] == val) {
					return false;
					
				}
			}
		}
		return true;
		
		
	}
	//Main File
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		int[][] arr = new int [9][9];
//		for(int i = 0 ; i < 9 ; i++) {
//			for(int j = 0 ; j < 9 ; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}
		int[][] arr = new int[][] {
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
		solveSudoku(arr, 0, 0);
        
	}

}
