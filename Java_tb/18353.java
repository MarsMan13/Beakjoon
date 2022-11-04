import java.util.*;
import java.io.*;

class Main{

	static int N;
	static int[] inputs;
	static int[] mem;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		inputs = new int[N];
		mem = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		// END OF INIT
		int answer = 0;
		for(int i = 0; i<N; i++){
			int beforeMax = 0;
			int curPower = inputs[i];
			for(int j = 0; j<i; j++){
				if(inputs[j] > curPower){
					beforeMax = Math.max(beforeMax, mem[j]);
				}
			}
			mem[i] = beforeMax + 1;
			answer = Math.max(answer, mem[i]);
		}
		System.out.println(N-answer);	
	}
}