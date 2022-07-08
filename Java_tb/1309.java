import java.util.*;
import java.io.*;


class Main{
	
	static int DIV = 9901;
	static int[][] cage = null;
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		cage = new int[N+1][3];
		// END OF INIT
		cage[1][0] = cage[1][1] = cage[1][2] = 1;
		for(int i = 2; i<=N; i++){
			cage[i][0] = (cage[i-1][1] + cage[i-1][2]) % DIV;
			cage[i][1] = (cage[i-1][0] + cage[i-1][2]) % DIV;
			cage[i][2] = (cage[i-1][0] + cage[i-1][1] + cage[i-1][2]) % DIV;
		}
		//
		System.out.println((cage[N][0] + cage[N][1] + cage[N][2]) % DIV);
	}
}