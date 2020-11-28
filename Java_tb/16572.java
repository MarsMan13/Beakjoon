import java.util.*;
import java.io.*;


class Main{

	static int[][] board = new int[2001][2001];
	static int result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		StringTokenizer st;
		int a,b,c;
		for(int i = 0; i<n; i++){
			st = new StringTokenizer(bf.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		
			board[a][b] = Math.max(board[a][b], c);
		}

		//END OF Init

		
		int pre;
		for(int i = 1; i<=2000; i++){
			for(int j = 1; j<=2000; j++){
				pre = 0;
				pre = Math.max(pre, board[i-1][j]-1);
				pre = Math.max(pre, board[i][j-1]-1);
				pre = Math.max(pre, board[i][j]);
				board[i][j] = pre;
				if(0 != pre){
					result++;
				}
			}
		}

		System.out.println(result);

	}

}

