import java.util.*;
import java.io.*;


class Main{
	
	static int n, m;
	static int[][] map = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());	m = Integer.parseInt(st.nextToken());
		
		map = new int[n+2][m+2];
		for(int i = 0; i<=n+1; i++)	map[i][0] = map[i][m+1] = 0;
		for(int j = 0; j<=m+1; j++)	map[0][j] = map[n+1][j] = 0;
		
		for(int i = 1; i<=n; i++){
			String line = bf.readLine();
			for(int j = 1; j<=m; j++){
				map[i][j] = line.charAt(j-1)-'0';
			}
		}
		//
		int[][] dp = new int[n+2][m+2];
		int maxLen = 0;
		
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=m; j++){
				if(map[i][j] == 1){
					int min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
					dp[i][j] = min+1;
					if(maxLen < dp[i][j])	maxLen = dp[i][j];
				}	
			}
		}
		//
		System.out.println(maxLen * maxLen);
	}
}
