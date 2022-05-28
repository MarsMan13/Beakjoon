import java.util.*;


class Main{
	
	static int[] dp = null;
	static int S;
	static final int MAX = 1000000;
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();	sc.close();
		dp = new int[2*S+1];	Arrays.fill(dp, 1000000);
		dp[1] = 0;
		
		for(int i = 1; i<=2*S; i++){
			// copy my self
			int paste = 1;	int copy = 1;
			for(int j = 2*i; j<=2*S; j+=i){
				if(dp[i] + copy + paste < dp[j]){
					dp[j] = dp[i] + copy + paste;
				}
				paste++;
			}
			// minor from i
			int minor = 1;
			for(int j = i-1; i/2<j; j--){
				if(dp[i] + minor < dp[j]){
					System.out.println("check1");
					dp[j] = dp[i] + minor;
				}
				minor++;
			}
		}
		
		System.out.println(dp[S]);
	}
	
}