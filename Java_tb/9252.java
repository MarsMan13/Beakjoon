import java.util.*;
import java.io.*;


class Main{
	
	static String input1, input2;
	static int len1, len2;
	
	static int[][] dp = null;
	static int[][] dp2 = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		input1 = bf.readLine();	input2 = bf.readLine();
		len1 = input1.length();	len2 = input2.length();
		
		dp = new int[len1][len2];
		dp2 = new int[26][len2];
		
		//
		
		for(char c = 'A'; c<='Z'; c++){
			for(int j = 0; j<len2; j++){
				if(input2.charAt(j) == c){
					dp2[c-'A'][j] = j;
				}
				else if(0 <= j-1){
					dp2[c-'A'][j] = dp2[c-'A'][j-1];
				}
				else{
					dp2[c-'A'][j] = -1;
				}
			}
		}
		
		int[][] dp3 = new int[len1][len2];
		
		int max = 0;
		for(int i = 0; i<len1; i++){
			for(int j = 0; j<len2; j++){
				int ret1 = 0;
				int ret2 = 0;
				// ret1 : Not selecting
				if(0<=i-1){
					ret1 = dp[i-1][j];
				}
				
				// ret2 : Selecting
				int tempC = input1.charAt(i) - 'A';
				int tempJ = dp2[tempC][j];
				if(tempJ != -1){
					ret2 = 1;
					if(0 <= i-1 && 0 <= tempJ-1)
						ret2 += dp[i-1][tempJ-1];
				}
				
				//
				dp[i][j] = Math.max(ret1, ret2);
				
				if(max < dp[i][j])
					max = dp[i][j];
				
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(max);

		StringBuilder sb = new StringBuilder();
	}
	
}