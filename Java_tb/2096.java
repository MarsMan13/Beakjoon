import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static int[][] map = null;
	static int[][] dp1 = null;
	static int[][] dp2 = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N+1][3+1];
		dp1 = new int[N+1][3+1];
		dp2 = new int[N+1][3+1];
		for(int i = 1; i<=N; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
			map[i][3] = Integer.parseInt(st.nextToken());
		}
		
		// END OF INIT
		dp1[1][1] = map[1][1];	dp1[1][2] = map[1][2];	dp1[1][3] = map[1][3];
		for(int i = 2; i<=N; i++){
			{	// j = 1	--> i-1, j / i-1, j+1
				int j = 1;
				dp1[i][j] = dp1[i-1][j] < dp1[i-1][j+1] ? dp1[i-1][j+1] : dp1[i-1][j];
				dp1[i][j] += map[i][j];
			}
			{	// j = 2	--> i-1, j-1 / i-1, j / i-1, j+1
				int j = 2;
				dp1[i][j] = dp1[i-1][j-1] < dp1[i-1][j] ? dp1[i-1][j] : dp1[i-1][j-1];
				if(dp1[i][j] < dp1[i-1][j+1])
					dp1[i][j] = dp1[i-1][j+1];
				dp1[i][j] += map[i][j];
			}
			{	// j = 3	--> i-1, j-1/ i-1, j
				int j = 3;
				dp1[i][j] = dp1[i-1][j] < dp1[i-1][j-1] ? dp1[i-1][j-1] : dp1[i-1][j];
				dp1[i][j] += map[i][j];
			}
		}
		dp2[1][1] = map[1][1];	dp2[1][2] = map[1][2];	dp2[1][3] = map[1][3];
		for(int i = 2; i<=N; i++){
			{	// j = 1	--> i-1, j / i-1, j+1
				int j = 1;
				dp2[i][j] = dp2[i-1][j] > dp2[i-1][j+1] ? dp2[i-1][j+1] : dp2[i-1][j];
				dp2[i][j] += map[i][j];
			}
			{	// j = 2	--> i-1, j-1 / i-1, j / i-1, j+1
				int j = 2;
				dp2[i][j] = dp2[i-1][j-1] > dp2[i-1][j] ? dp2[i-1][j] : dp2[i-1][j-1];
				if(dp2[i][j] > dp2[i-1][j+1])
					dp2[i][j] = dp2[i-1][j+1];
				dp2[i][j] += map[i][j];
			}
			{	// j = 3	--> i-1, j-1/ i-1, j
				int j = 3;
				dp2[i][j] = dp2[i-1][j] > dp2[i-1][j-1] ? dp2[i-1][j-1] : dp2[i-1][j];
				dp2[i][j] += map[i][j];
			}
		}
		
		int max = -1;
		int min = -1;
		for(int j = 1; j<=3; j++){
			if(max < dp1[N][j])
				max = dp1[N][j];
			if(min == -1 || dp2[N][j] < min)
				min = dp2[N][j];
		}
		System.out.println(max+" "+min);
	}
}

