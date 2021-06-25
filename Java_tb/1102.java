import java.util.*;
import java.io.*;


class Main{

	static int N;
	static int[][] pp = null;
	static int P;
	static int[] dp = new int[300000];
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		pp = new int[N+1][N+1];
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++){
				pp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//
		int cur = 0;
		String line = bf.readLine();
		for(int i = 1; i<=N; i++){
			int c = line.charAt(i-1);
			if(c == 'Y'){
				cur = (cur | (1 << i));
			}
		}
		P = Integer.parseInt(bf.readLine());
		Arrays.fill(dp, -1);
		System.out.println(dfs(cur, 0));
	}
	
	public static int dfs(int cur, int cost){
		if(dp[cur] != -1){
			return cost + dp[cur];
		}
		if(P<=Integer.bitCount(cur)){
			return cost;
		}
			
		int result = -1; 
		for(int i = 1; i<=N; i++){
			if((cur & (1 << i)) != 0) continue;
			int min = 500;
			for(int j = 1; j<=N; j++){
				if(((cur & (1 << j)) == 0))	continue;
				if(pp[i][j] < min)			min = pp[i][j];
			}
			int temp = dfs((cur | (1 << i)), cost + min);
			if(result == -1 || temp < result)
				result = temp;
		}
		return dp[cur] = result;
	}
	
	
}