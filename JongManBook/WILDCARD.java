import java.util.*;
import java.io.*;


class Main{
	
	static String W = "";
	static int N = 0;
	static String[] input = new String[1];
	static int[][] dp = new int[1][1];
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			W = bf.readLine();
			N = Integer.parseInt(bf.readLine());
			input = new String[N];
			for(int i = 0; i<N; i++)	input[i] = bf.readLine();
			Arrays.sort(input);	// N*log(N)
			//
			for(int i = 0; i<N; i++){
				dp = new int[W.length()+1][input[i].length()+1];
				int ret = def(0, 0, input[i]);
				if(ret == 2){
					sb.append(input[i]);	sb.append("\n");
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static int def(int wFrom, int inputFrom, String input){
		// BASE CASE
		if(W.length() <= wFrom && input.length() <= inputFrom)	return 2;
		if(W.length() <= wFrom && inputFrom < input.length())	return 1;
		if(wFrom < W.length() && input.length() <= inputFrom){
			if(W.charAt(wFrom) == '*')
				return dp[wFrom][inputFrom] = def(wFrom+1, inputFrom, input);
			return dp[wFrom][inputFrom] = 1;
		}	
		
		if(dp[wFrom][inputFrom] != 0)
			return dp[wFrom][inputFrom];
		
		char curC = W.charAt(wFrom);
		//
		int ret = 1;	// 0 : not okay
		if(curC == '?' || curC == input.charAt(inputFrom)){
			ret = def(wFrom+1, inputFrom+1, input);
		}
		else if(curC == '*'){
			if(def(wFrom+1, inputFrom, input) == 2 || (inputFrom < input.length() && def(wFrom, inputFrom+1, input) == 2))
				ret = 2;
		}
		return dp[wFrom][inputFrom] = ret;
	}
}