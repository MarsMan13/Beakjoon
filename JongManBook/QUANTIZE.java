import java.util.*;
import java.io.*;


class Main{
	
	static int N, S;
	static int[] input = null;
	static int min = 0, max = 0;
	static int[][] dp1 = null;
	static int[][][] dp2 = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());	S = Integer.parseInt(st.nextToken());
			input = new int[N];
			st = new StringTokenizer(bf.readLine());
			for(int i = 0; i<N; i++)	input[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(input);
			min = input[0];	max = input[N-1];
			dp1 = new int[max-min+1][N];
			for(int i = 0; i<=max-min; i++){
				int pivot = min + i;
				for(int j = 0; j<N; j++){
					int square = (pivot - input[j]) * (pivot - input[j]);
					dp1[i][j] = square;
					if(j != 0)	dp1[i][j] += dp1[i][j-1];
				}
			}
			//	upper : O(1000 * N) == O(1000 * 100)
			dp2 = new int[max-min+1][N][S+1];
			def(0, 0, S);
		}
		
	}
	
	public static int def(int i, int j, int depth){
		if(N<=i ||)
		
	}
}	