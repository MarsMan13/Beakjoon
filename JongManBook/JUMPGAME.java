import java.util.*;
import java.io.*;


class Main{
	
	static int[][] map = new int[1][1];
	static int[][] dp = new int[1][1];
	static int n = 1;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t<T; t++){
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			map = new int[n+2][n+2];
			dp = new int[n+2][n+2];
			for(int i = 1; i<=n; i++){
				st = new StringTokenizer(bf.readLine());
				for(int j = 1; j<=n; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// END OF INIT
			sb.append(def(1, 1) == 3 ? "YES" : "NO");	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static int def(int i, int j){
		
		if(i == n && j == n){
			return dp[i][j] = 3;
		}
		// end of base case
		
		dp[i][j] = 1;
		int step = map[i][j];
	
		int ret = 2;
		for(int s = 0; s<2; s++){
			int new_i = i + (ii[s] * step);	int new_j = j + (jj[s] * step);
			if((1<=new_i && new_i<=n) && (1<=new_j && new_j<=n) && dp[new_i][new_j] == 0)
				ret = Math.max(ret, (2 <= dp[new_i][new_j] ? dp[new_i][new_j] : def(new_i, new_j)));
		}
		return dp[i][j] = ret;
	}
	
	static int[] ii = new int[]{1, 0};
	static int[] jj = new int[]{0, 1};
}
