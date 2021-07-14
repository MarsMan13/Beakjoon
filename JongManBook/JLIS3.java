import java.util.*;
import java.io.*;


class Main{

	static int n = 0, m = 0;
	static int[] input1 = new int[1];
	static int[] input2 = new int[1];
	
	static int[][] dp = new int[1][1];
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());	m = Integer.parseInt(st.nextToken());
			input1 = new int[n+1];	input2 = new int[m+1];
			st = new StringTokenizer(bf.readLine());
			for(int i = 1; i<=n; i++)	input1[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=m; j++)	input2[j] = Integer.parseInt(st.nextToken());
			//
			//dp = new int[n+1][m+1];
			int result = 0;
			for(int tt = 0; tt<=1; tt++){
				dp = new int[n+1][m+1];
				for(int i = 1; i<=n; i++){
					result = Math.max(result, def(i-1, m, input1[i]));
				}
				
				// END OF FIRST RUN;
				{
					int temp = n;
					n = m;
					m = temp;
					//
					int[] tempInput = input1;
					input1 = input2;
					input2 =tempInput;
				}
			}
			// dp = new int[n+1][m+1];
			// for(int i = 1; i<=n; i++){
			// 	result = Math.max(result, def(i-1, m, input1[i]));
			// }
			sb.append(result);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush(); bw.close();
	}
	
	public static int def(int i, int j, int min){
		if(i<0 || j<0)	return 0;
		// base case
		
		if(dp[i][j] != 0){
			return dp[i][j];
		}
		
		int ret = 0;
		{
			for(int ii = i; 0<=ii; ii--){
				if(input1[ii] < min){
					ret = Math.max(ret, def(ii-1, j, input1[ii]));
				}
				for(int jj = j; 0<=jj; jj--){
					if(input2[jj] < min){
						ret = Math.max(ret, def(ii, jj-1, input2[jj]));
					}
				}
			}
		}
		// System.out.printf("i: %d, j: %d == %d\n", i, j, ret+1);
		return dp[i][j] = ret + 1;
	}
}

