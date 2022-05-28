import java.util.*;
import java.io.*;



class Main{
	
	static int N, K;
	static int[][] stuffs = null;
	static int[][] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		stuffs = new int[N+1][2];
		dp = new int[N+2][K+1];
		for(int i = 1; i<=N+1; i++)
			for(int j = 1; j<=K; j++)
				dp[i][j] = -1;
		
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			stuffs[i][0] = w;
			stuffs[i][1] = v;
		}
		// for(int i = 1; i<=N; i++){
		// 	for(int j = 1; j<=K; j++)
		// 		System.out.print(dp[i][j]);
		// 	System.out.println();
		// }
		System.out.println(def1(1, K));
	}
	
	public static int def1(int depth, int rest){
		if(N < depth)
			return 0;
		int v1 = 0; int v2 = 0;
		if(0<= rest - stuffs[depth][0]){
			if(dp[depth+1][rest-stuffs[depth][0]] != -1)
				v1 = stuffs[depth][1] + dp[depth+1][rest-stuffs[depth][0]];
			else
				v1 = stuffs[depth][1] + def1(depth+1, rest - stuffs[depth][0]);
		}
		if(dp[depth+1][rest] != -1)
			v2 = dp[depth+1][rest];
		else
			v2 = def1(depth+1, rest);
		return dp[depth][rest] = v1 < v2 ? v2 : v1;
	}
	
}

