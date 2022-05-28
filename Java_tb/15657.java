import java.util.*;
import java.io.*;

class Main{
	
	static int N, M;
	static int[] input = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		input = new int[N+1];
		//
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
		def1(0, 1, new int[M]);
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();	bw.close();
	}
	
	public static void def1(int depth, int start, int[] ary){
		if(depth == M){
			for(int i : ary){
				sb.append(i);	sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i<=N; i++){
			ary[depth] = input[i];
			def1(depth+1, i, ary);
		}
		
	}
}