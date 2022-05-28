import java.util.*;
import java.io.*;


class Main{
	
	static int n = 0;
	static int[][] map = null;
	static long[][][] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			n = Integer.parseInt(bf.readLine());
			map = new int[n+1][n+1];
			for(int i = 1; i<=n; i++){
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j = 1; j<=i; j++){
					map[i][j] = Integer.parseInt(st.nextToken());	
				}
			}
			// END OF INIT
			dp = new long[n+1][n+1][2];	// [i][0] : i's left, [i][1] : i's right
			for(int i = 0; i<=n; i++)
				for(int j = 0; j<=n; j++)
					for(int k = 0; k<2; k++)
						dp[i][j][k] = -1L;
			//
			sb.append(def(1, 1)[1]);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static long[] def(int i, int j){
		if(i == n)	return new long[]{map[i][j], 1L};
		
		if(dp[i][j][0] != -1L)	return dp[i][j];
		
		long[] left = def(i+1, j);
		long[] right = def(i+1, j+1);
		
		long[] ret = new long[2];
		if(left[0] > right[0]){
			ret[0] = left[0];	ret[1] = left[1];
		}
		else if(left[0] < right[0]){
			ret[0] = right[0];	ret[1] = right[1];
		}
		else{
			ret[0] = left[0];	ret[1] = 0L + left[1] + right[1];
		}
		ret[0] += 0L + map[i][j];
		return dp[i][j] = ret;
	}
}