import java.io.*;

class Main{

	static String input1,input2;
	public static void main(String[] args) throws IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		input1 = bf.readLine();	input2 = bf.readLine();
		int[][] dp = new int[input2.length()][input1.length()];
		int[][] dp2= new int[input2.length()][input1.length()];
		
		for(int i=0; i<input2.length(); i++){
			for(int j = 0; j<input1.length(); j++){
				if(input1.charAt(j) == input2.charAt(i)){
					dp[i][j]=1;
					if(0<=i-1&&0<=j-1)
						dp[i][j]+=dp[i-1][j-1];
					dp2[i][j] = 0;
				}
				else{
					int tp1=0;
					if(0<=i-1)
						tp1=dp[i-1][j];
					int tp2=0;
					if(0<=j-1)
						tp2=dp[i][j-1];
					if(tp2 < tp1){
						dp2[i][j] = 1;
						dp[i][j] = tp1;
					}
					else{
						dp2[i][j] = -1;
						dp[i][j] = tp2;
					}
				}
			}
		}
		
		System.out.println(dp[input2.length()-1][input1.length()-1]);
		int i = input2.length()-1;
		int j = input1.length()-1;
		StringBuilder sb = new StringBuilder();
		while(0<=i && 0<=j){
			if(dp2[i][j] == 0){
				sb.append(input2.charAt(i));
				i--;	j--;
			}
			else if(dp2[i][j] == 1)
				i--;
			else
				j--;
		}
		System.out.println(sb.reverse().toString());
	}
}