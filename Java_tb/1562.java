import java.util.*;


class Main{
	
	static final int DIV = 1000000000;
	static long[][][] dp = null;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	sc.close();
		
		dp = new long[N+1][10][1500];
		for(int i = 1; i<=N; i++)
			for(int j = 0; j<10; j++)
				for(int k = 0; k<1500; k++)
					dp[i][j][k] = -1L;

		CHECKER = 0;
		for(int i = 0; i<10; i++)
			CHECKER = CHECKER | (1 << i);

		long sum = 0;
		for(int i = 0; i<10; i++){
			sum = (sum + 1L * dfs(N, i, (1<<i)))%DIV;
		}
		System.out.println(sum);
	}
	
	static int CHECKER = 0;
	
	public static long dfs(int index, int i, int before){
		if(index < 1)
			return 0L;
		if(index == 1 && (before & CHECKER) == CHECKER){
			return 1L;
		}
		
		if(dp[index][i][before] != -1L)
			return dp[index][i][before];
		
		long sum = 0;
		for(int ii = -1; ii<=1; ii+=2){
			if(0 <= i+ii && i+ii < 10){
				if(i+ii == 0 && index-1 == 1)	continue;
				sum = (sum + 1L * dfs(index-1, i+ii, (before | (1 << i+ii)))) % DIV;
			}
		}
		return dp[index][i][before] = sum;
	}
}