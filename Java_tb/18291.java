import java.util.*;
import java.io.*;

class Main{
	
	static int N = 0;
	static int[] mem = null;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		mem = new int[50];
		mem[0] = 1;
		// END OF INIT
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			N = Integer.parseInt(bf.readLine());
			sb.append(def(N-2));
			sb.append("\n");
		}	
		System.out.println(sb.toString());
	}

	static long DIV = 1000000000L + 7L;
	public static long def(int pow){
		if(pow == 0)
			return 1L;
		long ret = def(pow/2);
		ret = ret * ret;
		if(pow % 2 == 1)
			ret *= 2L;
		return ret % DIV;
	}
}