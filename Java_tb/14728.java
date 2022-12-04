import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][T+1];
		Pair inputs[] = new Pair[N];
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			int K = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			inputs[i] = new Pair(K, S);
		}	
		//
		//dp[n][t] : n은 1 ~ n번째 단원을 이용해서 t시간안에서의 최적해
		//dp[N][T]를 구하자!
		//dp[n][t] = Max(dp[n-1][t], dp[n-1][t - cur.time] + cur.score); (단, cur.time <= t)
		for(int index = 1; index<=N; index++){
			for(int t = 1; t<=T; t++){
				Pair cur = inputs[index-1];
				if(cur.time <= t){
					dp[index][t] = Math.max(dp[index-1][t], dp[index-1][t-cur.time] + cur.score);
				}
				else{
					dp[index][t] = dp[index-1][t];
				}
			}
		}
		System.out.println(dp[N][T]);
	}
}

class Pair{
	int time, score;
	Pair(int time, int score){
		this.time = time;
		this.score = score;
	}
}