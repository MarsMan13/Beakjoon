import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static int[][] data = null;
	static final int MAX = 10000000;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		data = new int[N+1][3];
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
			data[i][2] = Integer.parseInt(st.nextToken());
		}
	
		//
		int min = MAX;
		for(int s = 0; s<3; s++){
			int[][] dp = new int[N+1][3];	
			for(int i = 1; i<=N; i++)	dp[i][0] = dp[i][1] = dp[i][2] = MAX;
			dp[1][s] = data[1][s];
			for(int i = 2; i<N; i++){
				for(int j = 0; j<3; j++){
					for(int b = 0; b<3; b++){
						if(j == b)	continue;
						if(dp[i-1][b] + data[i][j] < dp[i][j])
							dp[i][j] = dp[i-1][b] + data[i][j];
					}
				}
			}
			// i == N;
			for(int j = 0; j<3; j++){
				for(int b = 0; b<3; b++){
					if(j == s || j == b)	continue;
					if(dp[N-1][b] + data[N][j] < dp[N][j])
						dp[N][j] = dp[N-1][b] + data[N][j];
				}
			}
			for(int j = 0; j<3; j++)
				if(dp[N][j] < min)
					min = dp[N][j];
		}
		System.out.println(min);
	}
}