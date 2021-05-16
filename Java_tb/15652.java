import java.util.*;
import java.io.*;

class Main{
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	M = sc.nextInt();
		//
	
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
			ary[depth] = i;
			def1(depth+1, i, ary);
		}
		
	}
}