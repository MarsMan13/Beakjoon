import java.util.*;
import java.io.*;



class Main{

	static int T;
	static int n;
	static int[] input = null;
	static int[] until = null;
	static int[][] mem = null;
	

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		T = Integer.parseInt(st.nextToken());
		int[] result = new int[T];
		for(int t = 0; t < T; t++){
			st = new StringTokenizer(bf.readLine());
			// INIT VARIABLES	
			n = Integer.parseInt(st.nextToken());
			input = new int[n];
			until = new int[n];
			mem = new int[n][n];
			
			st = new StringTokenizer(bf.readLine());
			int sum = 0;
			for(int i = 0; i<n; i++){
				input[i] = Integer.parseInt(st.nextToken());
				sum += input[i];
				until[i] = sum;
			}
			// END OF INIT
		
			result[t] = partUp(0, n-1);
		}
		for(int t = 0; t<T; t++){
			System.out.println(result[t]);
		}
	}

	static int partUp(int from, int to){
		
		int min = -1;
	
		if(mem[from][to] != 0){
			return mem[from][to];
		}
		if(from == to){
			return 0;
		}

		for(int i = from; i<to; i++){
			int left = partUp(from, i);
			int right = partUp(i+1, to);

			if(min == -1 || (left + right < min)){
				min = left + right;
			}
		}
		if(from == 0){
			mem[from][to] = min + until[to];
		}
		else{
			mem[from][to] = min + (until[to] - until[from-1]);
		}
		return mem[from][to];
	}
}

