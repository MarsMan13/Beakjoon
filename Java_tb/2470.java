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
		int[] result = null;
		int resultSum = -2000000000-1;
		int from = 0;
		int to = N-1;
		while(from < to){
			int sum = inputs[from] + inputs[to];
			if(sum == 0){
				resultSum = sum;
				result = new int[]{inputs[from], inputs[to]};
				break;
			}
			else if(Math.abs(sum) < Math.abs(resultSum)){
				resultSum = sum;
				result = new int[]{inputs[from], inputs[to]};
			}

			if(sum > 0)
				to--;
			else
				from++;
		}
		System.out.printf("%d %d\n", result[0], result[1]);
	}
}