import java.util.*;
import java.io.*;

class Main{
	
	static int N;
	static char[][] image;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		image = new char[N][N];
		for(int i = 0; i<N; i++){
			String line = bf.readLine();
			for(int j = 0; j<N; j++){
				image[i][j] = line.charAt(j);
			}
		}
		// END OF INIT
		System.out.println(recursiveCompact(0, 0, N).toString());
	}

	public static StringBuilder recursiveCompact(int i, int j, int size){
		StringBuilder sb = new StringBuilder();
		boolean allSame = true;
		OUTER:
		for(int ii = i; ii<i+size; ii++){
			for(int jj = j; jj<j+size; jj++){
				if(image[i][j] != image[ii][jj]){
					allSame = false;
					break OUTER;
				}
			}
		}
		if(allSame)	return sb.append(image[i][j]);
		int nextSize = size/2;
		sb.append("(");
		
		sb.append(recursiveCompact(i, j, nextSize));
		sb.append(recursiveCompact(i, j+nextSize, nextSize));
		sb.append(recursiveCompact(i+nextSize, j, nextSize));
		sb.append(recursiveCompact(i+nextSize, j+nextSize, nextSize));
		
		sb.append(")");
		return sb;
	}
}