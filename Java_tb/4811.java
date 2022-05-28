import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		while(true){
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0)	break;
			//
			int maxW = N;
			int maxH = 2*N;
			long[][] dp = new long[maxW+1][maxH+1];	dp[0][1] = 1;
			for(int i = 0; i<=maxW; i++){
				for(int j = 0; j<=maxH; j++){
					if(i == 0 && j == 1)	continue;
					if(0 <= i-1 && j+1 <= maxH)
						dp[i][j] += (0L + dp[i-1][j+1]);
					if(0 <= j-1)
						dp[i][j] += (0L + dp[i][j-1]);
				}
			}
			sb.append(dp[N][0]);	sb.append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
}