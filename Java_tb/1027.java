import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static long[] height;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		height = new long[N+1];	
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=N; i++)
			height[i] = Long.parseLong(st.nextToken());
		
		//
		int[] count = new int[N+1];
		for(int i = 1; i<=N; i++){
			for(int j = i+1; j<=N; j++){
				// Seeing from i to j is visible.
				
				int flag = 0;
				for(int k = i+1; k<j; k++){
					long ret = (1L*(height[j] - height[i])*(k - i) + 1L*height[i]*(j - i)) - 1L*height[k]*(j - i);
					if(ret <= 0){
						flag = 1;
						break;
					}
				}
				if(flag == 0){
					count[i]++;
					count[j]++;
				}
			}
		}
		int max = 0;
		for(int i = 1; i<=N; i++)
			if(max < count[i])
				max = count[i];
		System.out.println(max);
	}
}