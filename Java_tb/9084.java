import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t<T; t++){
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			int[] coins = new int[N];
			for(int i = 0; i<N; i++)
				coins[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			int target = Integer.parseInt(st.nextToken());
			// END OF INIT
			
			int[] result = new int[target+1];
			
			for(int i = 0; i<N; i++){
				if(coins[i] <= target)	
					result[coins[i]] = 1;
			}
			
			for(int i = 1; i<=target; i++){
				for(int j = 1; j<=i; j++){
					result[i] += (result[j] * result[i-j]);
					if(result[i] != 0)
						System.out.println(i+" : "+result[i]);
				}
			}
			System.out.println(result[target]);
		}
	}
}