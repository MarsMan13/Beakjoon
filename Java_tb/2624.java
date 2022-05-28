import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());
		
		int[] coins = new int[k+1];	coins[0] = 0;
		TreeMap<Integer, Integer> cc = new TreeMap<>();
		for(int c = 1; c<=k; c++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int coin = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			coins[c] = coin;
			cc.put(coin, count);
		}
		Arrays.sort(coins);
		//
		long[][] dp = new long[k+1][T+1];
		for(int i = 0; i<=k; i++)	dp[i][0] = 1L;
		for(int i = 1; i<=k; i++){
			int coin = coins[i];
			int count = cc.get(coin);
			for(int j = 1; j<=T; j++){
				for(int c = 0; c<=count && coin * c <=j; c++){
					dp[i][j] += dp[i-1][j-coin * c];
				}
			}
		}
		System.out.println(dp[k][T]);	
	}
}