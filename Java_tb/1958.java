import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str1 = bf.readLine();	int len1 = str1.length();
		String str2 = bf.readLine();	int len2 = str2.length();
		String str3 = bf.readLine();	int len3 = str3.length();
		
		int[][][] dp = new int[len1+1][len2+1][len3+1];
		
		for(int i = 1; i<=len1; i++){
			char c1 = str1.charAt(i-1);
			for(int j = 1; j<=len2; j++){
				char c2 = str2.charAt(j-1);
				for(int k = 1; k<=len3; k++){
					char c3 = str3.charAt(k-1);
					//
					if(c1 == c2 && c2 == c3)
						dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
					else{
						dp[i][j][k] = Math.max(
							dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1])
						);
					}
				}
			}
		}
		System.out.println(dp[len1][len2][len3]);
	}
}
