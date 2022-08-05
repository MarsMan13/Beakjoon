import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int[] inputs = new int[N];
		for(int i = 0; i<N; i++){
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputs);

		// END OF INIT
		long ret = 0;
		for(int i = 0; i<N; i++){
			if(inputs[i] > 0) break;
			int from = i + 1;
			int to = N - 1;
			while(from < to){
				int sum = inputs[i] + inputs[from] + inputs[to];
				
				if(sum == 0){
					if(inputs[from] == inputs[to]){
						ret += (to - from + 1) * (to - from) / 2;
						break;
					}
					int fromCount = 1;
					int toCount = 1;
					for(int j = from+1; j<N; j++){
						if(inputs[from] != inputs[j])	break;
						fromCount++;
						from++;
					}
					for(int j = to-1; from<j; j--){
						if(inputs[to] != inputs[j])	break;
						toCount++;
						to--;
					}
					ret += fromCount * toCount;
				}
				if(sum > 0)
					to--;
				else
					from++;
			}
		}
		System.out.println(ret);
	}
}