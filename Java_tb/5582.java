import java.util.*;
import java.io.*;


class Main{
	
	static int[] str1 = null;
	static int[] str2 = null;
	static int[][] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input1 = bf.readLine();
		str1 = new int[input1.length()+1];
		String input2 = bf.readLine();
		str2 = new int[input2.length()+1];
		for(int i = 0; i<input1.length(); i++){
			str1[i+1] = input1.charAt(i);
		}
		for(int i = 0; i<input2.length(); i++){
			str2[i+1] = input2.charAt(i);
		}
		// END OF INIT
		dp = new int[input1.length()+1][input2.length()+1];
	
		int result = 0;
		for(int i = 1; i<=input1.length(); i++){
			for(int j = 1; j<=input2.length(); j++){
				if(str1[i] == str2[j]){
					dp[i][j] = dp[i-1][j-1]+1;
					if(result < dp[i][j])
						result = dp[i][j];
				}
			}
		}
		System.out.println(result);
	}
}