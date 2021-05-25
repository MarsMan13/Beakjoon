import java.util.*;
import java.io.*;


class Main{
	
	static StringBuilder sb = new StringBuilder();
	static int[][] board = new int[10][10];
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		for(int i = 1; i<=9; i++){
			String line = bf.readLine();
			for(int j = 1; j<=9; j++){
				board[i][j] = (int)line.charAt(j-1);
			}
		}
		
		def1();
		
		System.out.println(sb.toString());	
	}
	
	public static void def1(){
		int flag = 0;
		int[] possible = new int[]{0,1,2,3,4,5,6,7,8,9};
		outer:	
		for(int i = 1; i<=9; i++){
			for(int j = 1; j<=9; j++){
				if(board[i][j] == 0){
					//
					
					if(i == 1 && j == 2)
						System.out.println("check");
					
					for(int k = 1; k<=9; k++)
						possible[board[i][k]] = possible[board[j][k]] = 0;
					//
					int area_i = (i-1)/3 * 3 + 1;
					int area_j = (j-1)/3 * 3 + 1;
					for(int ii = area_i; ii<area_i+3; ii++){
						for(int jj = area_j; jj<area_j+3; jj++){
							possible[board[ii][jj]] = 0;
						}
					}
					// END OF CHECK POSSIBLE
					if(i == 1 && j == 2)
						System.out.println(possible);
					for(int p = 1; p<=9; p++){
						if(possible[p] != 0){
							board[i][j] = possible[p];
							def1();
							board[i][j] = 0;
						}
					}
					break outer;
				}
			}
		}
		//
		if(flag == 0){
			for(int i = 1; i<=9; i++){
				for(int j = 1; j<=9; j++)
					sb.append(board[i][j]);
				sb.append("\n");
			}
		}
		
	}
}