import java.util.*;
import java.io.*;


class Main{
	
	static String str1, str2;
	static int len1, len2;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		str1 = bf.readLine();	str2 = bf.readLine();
		len1 = str1.length();	len2 = str2.length();
		int[][] dp = new int[len1+1][len2+1];
		int[][] dp2 = new int[len1+1][len2+1];
		
		for(int i = 1; i<=len1; i++){
			char c1 = str1.charAt(i-1);
			for(int j = 1; j<=len2; j++){
				char c2 = str2.charAt(j-1);
				if(c1 == c2){
					dp[i][j] = 1 + dp[i-1][j-1];
					dp2[i][j] = 2;
				}
				else{
					int flag = (dp[i-1][j] < dp[i][j-1] ? 1 : -1);
					if(flag == 1)
						dp[i][j] = dp[i][j-1];
					else
						dp[i][j] = dp[i-1][j];
					dp2[i][j] = flag;
				}
			}
		}
		System.out.println(dp[len1][len2]);
		StringBuilder sb = new StringBuilder();
		int i = len1;	int j = len2;
		while(0<i && 0<j){
			if(dp2[i][j] == 2){
				sb.append(str1.charAt(i-1));
				i--;	j--;
			}
			else if(dp2[i][j] == 1)
				j--;
			else
				i--;
		}
		System.out.println(sb.reverse().toString());
	}
}

