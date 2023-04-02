import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		
		for(int i = 0; i<N; i++){
			String line = bf.readLine();
			for(int j = 0; j<M; j++){
				map[i][j] = line.charAt(j) - '0';
			}
		}
		// END OF INIT
		int answer = -1;
		for(int b = 0; b < (1 << (N * M)); b++){
			int tempSum = 0;
			for(int i = 0; i<N; i++){
				int power = 0;
				for(int j = 0; j<M; j++){
					int target = i * M + j;
					if((b & (1 << target)) == 0){
						power *= 10;
						power += map[i][j];
					}
					else{
						tempSum += power;
						power = 0;
					}
				}
				tempSum += power;
			}
			//
			for(int j = 0; j<M; j++){
				int power = 0;
				for(int i = 0; i<N; i++){
					int target = i * M + j;
					if((b & (1 << target)) != 0){
						power *= 10;
						power += map[i][j];
					}
					else{
						tempSum += power;
						power = 0;
					}
				}
				tempSum += power;
			}
			answer = Math.max(answer, tempSum);
		}
		System.out.println(answer);
	}
}