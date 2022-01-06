
import java.util.HashSet;
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
		// insert element from 1 to 9 in place of 0
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
		
	//check previous number and next number is same or not
	static boolean isValidSudoku(int[][] board) {      
	        for(int i=0; i < 9; i++){
	            HashSet<Integer> row = new HashSet();
	            HashSet<Integer> col = new HashSet();
	            HashSet<Integer> Box = new HashSet();
	
	            for(int j=0; j < 9; j++){
	                if(board[i][j] != 0 && !row.add(board[i][j]))
	                    return false;
	                if(board[j][i] != 0 &&!col.add(board[j][i]))
	                    return false;
	                int box_row = 3 * (i/3) + j/3;
	                int box_col = 3 * (i%3) + j%3;
	                if(board[box_row][box_col] != 0 && !Box.add(board[box_row][box_col]))
	                    return false;
	            }
	        }       
	        return true;
	    }
	//check the number is valid for that position or not , by checking these condition
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
		System.out.println("1. User Input");
		System.out.println("2. Already input value");
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		if(a==1) {
			int[][] arr = new int [9][9];
			for(int i = 0 ; i < 9 ; i++) {
				for(int j = 0 ; j < 9 ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println();
			if(!isValidSudoku(arr))
	        	System.out.println("Invalid board!");
	        else
	        	solveSudoku(arr, 0, 0);
		}
		else if (a==2) {
			System.out.println("1. Valid Board");
			System.out.println("2. Invalid Board");
			int b =sc.nextInt();
			if(b==1) {
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
		        System.out.println("{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },\r\n"
		        		+ "{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },\r\n"
		        		+ "{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },\r\n"
		        		+ "{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },\r\n"
		        		+ "{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },\r\n"
		        		+ "{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },\r\n"
		        		+ "{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },\r\n"
		        		+ "{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },\r\n"
		        		+ "{ 0, 0, 5, 2, 0, 6, 3, 0, 0 }");
		        System.out.println();
		        if(!isValidSudoku(arr))
		        	System.out.println("Invalid board!");
		        else
		        	solveSudoku(arr, 0, 0);
			}
			else if (b==2) {
				int[][] arr = new int[][] {
		            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
		            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
		            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
		            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
		            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
		            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
		            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
		            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
		            { 0, 5, 5, 2, 0, 6, 3, 0, 0 }
		        };
		        System.out.println("{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },\r\n"
		        		+ "{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },\r\n"
		        		+ "{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },\r\n"
		        		+ "{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },\r\n"
		        		+ "{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },\r\n"
		        		+ "{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },\r\n"
		        		+ "{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },\r\n"
		        		+ "{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },\r\n"
		        		+ "{ 0, 5, 5, 2, 0, 6, 3, 0, 0 }");
		        System.out.println();
		        if(!isValidSudoku(arr))
		        	System.out.println("Invalid board!");
		        else
		        	solveSudoku(arr, 0, 0);	
			}
			else {
				System.out.println("Only number 1 and 2");
			}
		}
		else {
			System.out.println("Only number 1 and 2");
		}
	}
}
