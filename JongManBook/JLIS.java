import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());	int m = Integer.parseInt(st.nextToken());
			int[] input1 = new int[n];	int[] input2 = new int[m];
			st = new StringTokenizer(bf.readLine());
			for(int i = 0; i<n; i++)
				input1[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			for(int i = 0; i<m; i++)
				input2[i] = Integer.parseInt(st.nextToken());
			int[] totInput = new int[n+m];
			{
				// i about input1, j about input2
				int i = 0;	int j = 0;
				int k = 0;	//	k about totInput
				while(k<n+m){
					if(i < n && (m<=j || input1[i] < input2[j]))
						totInput[k++] = input1[i++];
					else
						totInput[k++] = input2[j++];
				}
			}
			// END OF INIT
			int result = 1;
			int[] dp = new int[n+m];
			Arrays.fill(dp, 1);
			for(int i = 1; i<n+m; i++){
				for(int j = 0; j<i; j++){
					if(totInput[j] < totInput[i] && dp[i] < dp[j] + 1)
						dp[i] = dp[j] + 1;
				}
				if(result < dp[i])	result = dp[i];
			}
			// END OF PROCESS
			sb.append(result);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush(); bw.close();
	}
}