import java.util.*;
import java.io.*;

class Main{
	
	static int R, C, N;
	static int[] ii = new int[]{1, -1 ,0 ,0};
	static int[] jj = new int[]{0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		char[][][] results = new char[2][R][C];
		//
		for(int i = 0; i<R; i++){
			String line = bf.readLine();
			for(int j = 0; j<C; j++){
				results[0][i][j] = line.charAt(j);
				if(results[0][i][j] == 'O'){
					results[1][i][j] = '.';
					for(int s = 0; s<4; s++){
						if(0<=i + ii[s] && i + ii[s] <R && 0 <= j+jj[s] && j+jj[s] <C){
							results[1][i+ii[s]][j+jj[s]] = '.';
						}
					}
				}
			}
		}
		for(int i = 0; i<R; i++)
			for(int j = 0; j<C; j++)
				if(results[1][i][j] != '.')
					results[1][i][j] = 'O';
		
		//
		if(N % 4 == 1 || N % 4 == 3){
			int index = N%4 == 1 ? 0 : 1;
			for(int i = 0; i<R; i++){
				for(int j = 0; j<C; j++){
					System.out.print(results[index][i][j]);
				}
				System.out.println();
			}
		}
		else{
			for(int i = 0; i<R; i++){
				for(int j = 0; j<C; j++){
					System.out.print("O");
				}
				System.out.println();
			}
		}
	}
}