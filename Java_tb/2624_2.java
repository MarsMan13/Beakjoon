
import java.util.*;
import java.io.*;


class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());
		
		Coin[] coins = new Coin[k+1];	coins[0] = new Coin(0, 0);
		for(int c = 1; c<=k; c++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int coin = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			coins[c] = new Coin(coin, count);
		}
		Arrays.sort(coins);
		// END OF INIT
		long[][] dp = new long[k+1][T+1];
		for(int i = 0; i<=k; i++)	dp[i][0] = 1L;
		for(int i = 1; i<=k; i++){
			int coin = coins[i].coin;
			int count = coins[i].count;
			for(int j = 1; j<=T; j++){
				for(int c = 0; c<=count && coin * c <=j; c++){
					dp[i][j] += dp[i-1][j-coin * c];
				}
			}
		}
		System.out.println(dp[k][T]);	
	}
}

class Coin implements Comparable<Coin>{
	int coin, count;
	Coin(int c, int c2){this.coin = c;	this.count = c2;}
	@Override
	public int compareTo(Coin o){
		return this.coin - o.coin;
	}
}