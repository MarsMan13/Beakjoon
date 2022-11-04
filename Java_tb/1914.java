import java.util.*;
import java.io.*;
import java.math.*;

class Main{
	static int N;
	static long counter = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		if(N <= 20){
			def(N, 1, 2, 3);
			System.out.println(counter);
			System.out.println(sb.toString());	
		}
		else{
			System.out.println( (new BigInteger("2")).pow(N).add(new BigInteger("-1")));
		}
	}

	public static long def2(int target){
		if(target == 1)	return 1L;
		return 2L * def2(target-1) + 1;
	}

	public static void def(int target, int from, int mid, int to){
		if(1 < target){
			def(target-1, from, to, mid);
		}
		sb.append(from);
		sb.append(" ");
		sb.append(to);
		sb.append("\n");
		counter++;
		if(1 < target){
			def(target-1, mid, from, to);
		}
	}
	
}