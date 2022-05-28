import java.util.*;
import java.io.*;



class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		int[] dp_0 = new int[41];
		int[] dp_1 = new int[41];
		for(int i = 0; i<41; i++){
			dp_0[i] = -1;	dp_1[i] = -1;
		}
		dp_0[0] = 1; dp_0[1] = 0;
		dp_1[0] = 0; dp_1[1] = 1;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			int target = Integer.parseInt(bf.readLine());
			sb.append(finder(dp_0, target));
			sb.append(" ");
			sb.append(finder(dp_1, target));
			sb.append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	public static int finder(int[] ary, int n){
		if(ary[n] != -1)
			return ary[n];
		return ary[n] = finder(ary, n-1) + finder(ary, n-2);
	}
}