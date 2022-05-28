import java.util.*;
import java.io.*;

// time complex : 100 millions.
class Main{
	
	static int N, S;
	static int[] input = null;
	static int rowMax = 0;
	static int[][] dp1 = null;
	static int[][][] dp2 = null;
	
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
			rowMax = input[N] - input[1];
			dp1 = new int[rowMax+1][N+1];
			for(int i = 0; i<=rowMax; i++){
				int pivot = input[1] + i;
				for(int j = 1; j<=N; j++){
					int square = (pivot - input[j]) * (pivot - input[j]);
					dp1[i][j] = square + dp1[i][j-1];
				}
			}
			//	upper : O(1000 * N) == O(1000 * 100)
			dp2 = new int[S+1][rowMax+1][N+1];
			for(int s = 0; s<=S; s++)
				for(int i = 0; i<=rowMax; i++)
					for(int j = 1; j<=N; j++)
						dp2[s][i][j] = -1;
			sb.append(def(S, 0, 1));	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
		
	}

	public static int def(int depth, int i, int j){
		if(dp2[depth][i][j] != -1)	return dp2[depth][i][j];
		
		if(i == rowMax)	return dp1[i][N] - dp1[i][j-1];
		// else
		int min = dp1[i][N] - dp1[i][j-1];
		for(int jj = j; jj<N && depth != 1; jj++){
			int temp = dp1[i][jj] - dp1[i][j-1];
			temp += def(depth-1, i+1, jj+1);
			if(temp < min)	min = temp;
		}
		{
			int temp = def(depth, i+1, j);
			if(temp < min) min = temp;
		}	
		return dp2[depth][i][j] = min;
	}
}	