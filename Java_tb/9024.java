import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t<T; t++){
			// FOR EACH LOOP
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			int[] inputs = new int[n];
			for(int i = 0; i<n; i++){
				inputs[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(inputs);
			// END OF INIT
			int resultDiff = 100000000*2 + 1;
			int resultCount = 0;
			int from = 0;
			int to = n-1;
			while(from < to){
				int sum = inputs[from] + inputs[to];
				int diff = (K <= sum) ? sum - K : K - sum;
				if(diff < resultDiff){
					resultDiff = diff;
					resultCount = 1;
				}
				else if(diff == resultDiff)
					resultCount++;
				
				if(K < sum)
					to--;
				else
					from++;
			}
			sb.append(resultCount);
			sb.append("\n");
		}
		System.out.print(sb.toString());	
	}
}