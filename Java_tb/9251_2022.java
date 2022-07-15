import java.util.*;
import java.io.*;

class Main{

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str1 = bf.readLine();
		String str2 = bf.readLine();
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		int max = 0;
		for(int i = 1; i<=str1.length(); i++){
			for(int j = 1; j<=str2.length(); j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(max < dp[i][j])
					max = dp[i][j];
			}
		}
		System.out.println(max);
	}
}