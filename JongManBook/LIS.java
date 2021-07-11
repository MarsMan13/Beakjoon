import java.util.*;
import java.io.*;


class Main{
	
	static int N = 0;
	static int[] input = new int[1];
	static int[] dp = new int[1];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			N = Integer.parseInt(bf.readLine());
			input = new int[N+1];	dp = new int[N+1];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int i = 1; i<=N; i++)	input[i] = Integer.parseInt(st.nextToken());
			//
			int result = 1;
			Arrays.fill(dp, 1);
			for(int i = 2; i<=N; i++){
				for(int j = 1; j<i; j++){
					if(input[j] < input[i])
						dp[i] = Math.max(dp[i], dp[j]+1);
				}
				if(result < dp[i])	result = dp[i];
			}
			sb.append(result);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
}