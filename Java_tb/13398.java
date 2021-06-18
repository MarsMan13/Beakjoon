import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] input = new int[n+1];
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=n; i++)	input[i] = Integer.parseInt(st.nextToken());
		// get inputs
		
		int max = Integer.MIN_VALUE;
		
		int[] dp1 = new int[n+2];	//  ==>
		{
			int sum = 0;
			for(int i = 1; i<=n; i++){
				sum += input[i];
				dp1[i] = sum;
				if(max < sum)
					max = sum;
				if(sum < 0)
					sum = 0;
			}
			
		}
		int[] dp2 = new int[n+2];	// <==
		{
			int sum = 0;
			for(int i = n; 0<i; i--){
				sum += input[i];
				dp2[i] = sum;
				if(max < sum)
					max = sum;
				if(sum < 0)
					sum = 0;
			}
		}
		if(2<=n)	
			for(int i = 1; i<=n; i++){
				int left = dp1[i-1];
				int right = dp2[i+1];
				if(max < left + right)
					max = left + right;
			}
		System.out.println(max);
	}
}