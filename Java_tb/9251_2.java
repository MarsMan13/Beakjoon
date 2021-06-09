import java.io.*;
class Main{
	static String input1,input2;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		input1 = bf.readLine();	input2 = bf.readLine();
		int[][] dp = new int[input2.length()][input1.length()];
		
		for(int i=0; i<input2.length(); i++){
			for(int j = 0; j<input1.length(); j++){
				if(input1.charAt(j) == input2.charAt(i)){
					dp[i][j]=1;
					if(0<=i-1&&0<=j-1)
						dp[i][j]+=dp[i-1][j-1];
				}
				else{
					int tp1=0;
					if(0<=i-1)
						tp1=dp[i-1][j];
					int tp2=0;
					if(0<=j-1)
						tp2=dp[i][j-1];
					dp[i][j]=Math.max(tp1,tp2);
				}
			}
		}
		System.out.print(dp[input2.length()-1][input1.length()-1]);
	}
}