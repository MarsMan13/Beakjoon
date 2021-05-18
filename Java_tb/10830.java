import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static long B;
	static int[][] matrix = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	B = Long.parseLong(st.nextToken());
		matrix = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++)
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// END OF INIT;
		int[][] ret = def1(B);
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=N; j++){
				System.out.print(ret[i][j]%1000);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] def1(long b){
		if(b == 1 || b == 0)
			return matrix;
		if(b % 2 == 1){	// b is odd
			int[][] tempMtx = def1((b-1)/2);
			return def2(def2(tempMtx, tempMtx), matrix);
		}
		else{			// b is even
			int[][] tempMtx = def1(b/2);
			return def2(tempMtx, tempMtx);
		}
	}
	
	public static int[][] def2(int[][] mtx1, int[][] mtx2){
		int[][] ret = new int[N+1][N+1];
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=N; j++){
				for(int k = 1; k<=N; k++){
					ret[i][j] = (ret[i][j] + mtx1[i][k] * mtx2[k][j])%1000;
				}
			}
		}
		return ret;
	}
}