import java.util.*;
import java.io.*;

class Main{
	
	static int N;
	static char[][] results = null;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		results = new char[N][N];

		def(0,0,N,0);

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				sb.append(results[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void def(int i, int j, int n, int index){
		if(index == 4){
			for(int ii = i; ii<i+n; ii++){
				for(int jj = j; jj<j+n; jj++){
					results[ii][jj] = ' ';
				}
			}
			return; 
		}
		if(n == 1){
			results[i][j] = '*';
			return;
		}
		// RECURSIVE
		int nextN = n/3;
		for(int ii = 0; ii<3; ii++){
			for(int jj = 0; jj<3; jj++){
				def(i+nextN * ii, j + nextN * jj, nextN, ii * 3 + jj);		
			}
		}
	}
}