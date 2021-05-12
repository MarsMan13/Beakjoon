import java.util.*;
import java.io.*;



class Main{
	
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			int n = Integer.parseInt(bf.readLine());
			int[][] map = new int[2][n+1];
			for(int i = 0; i<2; i++){
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j = 1; j<=n; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// END OF INIT
			int[][] dp = new int[2][n+1];
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			int max = dp[0][1] < dp[1][1] ? dp[1][1] : dp[0][1];
			for(int j = 2; j<=n; j++){
				for(int i = 0; i<2; i++){
					int i1 = 0; 		int j1 = j-2;
					int i2 = 1; 		int j2 = j-2;
					int i3 = (i+1)%2;	int j3 = j-1;
					int cur = Math.max(dp[i1][j1], Math.max(dp[i2][j2], dp[i3][j3]));
					dp[i][j] = cur + map[i][j];
					if(max < dp[i][j])
						max = dp[i][j];
				}
			}
			sb.append(max); sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString()); bw.flush(); bw.close();
	}
}


