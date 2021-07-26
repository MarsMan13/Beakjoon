import java.util.*;
import java.io.*;


class Main{
	
	static long n, p, l;	// n, position, length
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = 1L * Integer.parseInt(st.nextToken());
			p = 1L * Integer.parseInt(st.nextToken());
			l = 1L * Integer.parseInt(st.nextToken());
			//
			def(0L, "FX", p, l);
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static void def(long depth, String sit, long p1, long l1){
		
		if(depth == n){
			sb.append(sit.substring((int)p1-1, (int)(p1+l1-1)));
			return;
		}
		
		long length = calc(n-depth);
		long leftLength = length/2;
		long p2 = p1 + l1 - 1L;
		String rightSit = makeSit(sit);
		String mid = rightSit.substring(rightSit.length()/2, rightSit.length()/2 + 1);
		String leftSit = rightSit.substring(0, 2);
		rightSit = rightSit.substring(3);
		
		if(p2 <= leftLength){	// all in left
			def(depth+1, leftSit, p1, l1);	
		}
		else if(leftLength+2 <= p1){	// all in right
			def(depth+1, rightSit, p1 - (leftLength + 1L), l1);
		}
		else{
			if(p1 <= leftLength)
				def(depth+1, leftSit, p1, leftLength - p1 + 1L);
			sb.append(mid);
			if(leftLength+2 <= p2)
				def(depth+1, rightSit, 1, p2 - leftLength - 1);
		}
	}
		
	static String subX = "X+YF";
	static String subY = "FX-Y";
	
	public static String makeSit(String sit){
		if(sit.charAt(1) == 'X'){
			return "F".concat(subX);
		}
		return subY.concat("F");
	}
	
	public static long calc(long i){
		return (long)Math.pow(2L, i+1) + (long)Math.pow(2L, i) - 1L;
	}
}