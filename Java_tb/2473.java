import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static int[] input = null;
	static final long MAX = 1000000000;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		input = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		// END OF INIT
		
		long ret = 3 * MAX + 1;
		int[] retAry = new int[3];
		
		for(int i = 0; i<N-2; i++){
			int left = i+1;
			int right = N-1;
			//
			for(; left < right ; left++){
				long sum = input[i] + input[left];
				
				for(; left < right; right--){
					sum += input[right];
					if(Math.abs(sum) < ret){
						ret = Math.abs(sum);
						retAry[0] = input[i];
						retAry[1] = input[left];
						retAry[2] = input[right];
					}
					if(sum <= 0){
						sum -= input[right];
						break;
					}
					sum -= input[right];
				}
				
			}
		}
	
		System.out.println(retAry[0] + " " + retAry[1] + " " + retAry[2]);
	}
}
