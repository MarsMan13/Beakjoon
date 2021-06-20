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
			int[] dp = new int[N+1][3];	
			for(int i = 1; i<=N; i++)	dp[i][0] = dp[i][1] = dp[i][2] = MAX;
			dp[1][s] = data[1][s];
			int before = s;
			for(int i = 2; i<N; i++){
				System.out.println(before);
				for(int j = 0; j<3; j++){
					if(before == j)
						continue;
					if(dp[i-1] + data[i][j] < dp[i]){
						dp[i] = dp[i-1] + data[i][j];
						before = j;
					}
				}
			}
			// i == N;
			for(int j = 0; j<3; j++){
				if(j == before || j == s)
					continue;
				if(dp[N-1] + data[N][j] < dp[N]){
					dp[N] = dp[N-1] + data[N][j];
					before = j;
				}
			}
			if(dp[N] < min)
				min = dp[N];
		}
		System.out.println(min);
	}
}