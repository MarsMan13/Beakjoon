import java.util.*;
import java.io.*;

// time complex : 100 millions.
class Main{
	
	static int N, S;
	static int[] input = null;
	static int rowMax = 0;
	static int[][] dp1 = null;
	static int[][] dp2 = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());	S = Integer.parseInt(st.nextToken());
			input = new int[N+1];	input[0] = -1;
			st = new StringTokenizer(bf.readLine());
			for(int i = 1; i<=N; i++)	input[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(input);
			dp1 = new int[3][N+1];
			dp2 = new int[S+1][N+1];
			for(int i = 1; i<=N; i++){
				dp1[1][i] = input[i] + dp1[1][i-1];
				dp1[2][i] = input[i] * input[i] + dp1[2][i-1];
			}
			for(int i = 0; i<=S; i++)
				for(int j = 0; j<=N; j++)
					dp2[i][j] = -1;
			// END OF INIT
		
			sb.append(def(1, S));	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
		
	}

	public static int cal(int from, int end){
		int m = dp1[1][end] - dp1[1][from-1];
		m = (int)Math.round((float)m/(end - from + 1));
		int ret = (dp1[2][end] - dp1[2][from-1]) - (2*m*(dp1[1][end] - dp1[1][from-1])) + (m*m*(end-from+1));
		return ret;
	}
	
	public static int def(int from, int parts){
		
		if(N < from)	return 0;
		if(parts < 1)	return 987654321;
		
		if(dp2[parts][from] != -1)	return dp2[parts][from];
		
		int min = 987654321;
		for(int i = from; i<=N; i++){
			min = Math.min(min, cal(from, i) + def(i+1, parts-1));
		}
		return dp2[parts][from] = min;
	}
}	