import java.util.*;
import java.io.*;


class Main{
	
	static int N = 0;
	static int min = -1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		int[][] input = new int[N][3];
		int[][] dp = new int[N][3];	

		
		for(int i = 0; i<N; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int Rcost = Integer.parseInt(st.nextToken());
			int Gcost = Integer.parseInt(st.nextToken());
			int Bcost = Integer.parseInt(st.nextToken());

			input[i][0] = Rcost;
			input[i][1] = Gcost;
			input[i][2] = Bcost;
		}
		
		for(int j = 0; j<3; j++){
			dp[N-1][j] = input[N-1][j];
		}
		for(int i = (N-1)-1; 0<=i; i--){
			for(int j = 0; j<3; j++){
				int tempMin = -1;
				for(int jj = 0; jj<3; jj++){
					if(j == jj)
						continue;
					if(tempMin == -1 || input[i][j] + dp[i+1][jj] < tempMin)
						tempMin = input[i][j] + dp[i+1][jj];
				}
				dp[i][j] = tempMin;
			}
		}
		int totMin = -1;
		for(int j = 0; j<3; j++){
			if(totMin == -1 || dp[0][j] < totMin)
				totMin = dp[0][j];
		}
		
		System.out.println(totMin);
		
	}
	
}

