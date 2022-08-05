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
		int test = 0;
		for(int i = 0; i<N-2; i++){
			for(int j = i+1; j<N-1; j++){
				int target = -1 * (inputs[i] + inputs[j]);
				int index = Arrays.binarySearch(inputs, j+1, N, target);
				if(index < 0)	continue;
				int count = 1;
				for(int k = index+1; k<N; k++){
					if(target != inputs[k])	break;
					count++;
				}
				for(int k = index-1; j<k; k--){
					if(target != inputs[k])	break;
					count++;
				}
				ret += count;
			}
		}
		System.out.println(ret);
	}
}