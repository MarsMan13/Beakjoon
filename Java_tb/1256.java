import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main{

	static int N, M, K;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		//
		BigInteger[][] dp = new BigInteger[N+1][M+1];
		for(int i = 0; i<=N; i++)	dp[i][0] = BigInteger.ONE;
		for(int j = 0; j<=M; j++)	dp[0][j] = BigInteger.ONE;
		for(int i = 1; i<=N; i++)
			for(int j = 1; j<=M; j++)
				dp[i][j] = dp[i-1][j].add(dp[i][j-1]);
		
	
		BigInteger KK = BigInteger.valueOf(K);
		if(dp[N][M].compareTo(KK) == -1)
			System.out.println(-1);
		else{
			StringBuilder sb = new StringBuilder();
			int i = N;	int j = M;
			int count = 0;
			while(count < N+M){
				if(0 <= i-1 && KK.compareTo(dp[i-1][j]) != 1){
					sb.append("a");
					i--;
				}
				else{
					sb.append("z");
					if(0 <= i-1)
						KK =  KK.subtract(dp[i-1][j]);
					j--;
				}
				count++;
			}
			System.out.println(sb.toString());
		}
	}
	
}