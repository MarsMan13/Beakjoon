import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());	int k = Integer.parseInt(st.nextToken());
		int[] input = new int[n+1];
		int[][] dp = new int[n+1][k+1];
		for(int i = 1; i<=n; i++){
			input[i] = Integer.parseInt(bf.readLine());
		}
		//
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=k; j++){
				int comp1 = dp[i-1][j];
				int comp2 = 0;
				for(int kk = input[i]; kk<=j; kk+=input[i]){
					if(j - kk == 0)
						comp2 += 1;
					else
						comp2 += dp[i-1][j-kk];
				}
				dp[i][j] = comp1 + comp2;
			}
		}
		System.out.println(dp[n][k]);
	
	}
}