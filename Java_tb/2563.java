import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[100][100];
		for(int t = 0; t<N; t++){
			st = new StringTokenizer(bf.readLine());
			int left = Integer.parseInt(st.nextToken());
			int bottom = Integer.parseInt(st.nextToken());
			//
			for(int i = bottom; i<bottom+10; i++){
				for(int j = left; j<left+10; j++){
					map[i][j] = 1;
				}
			}
		}	
		int count = 0;
		for(int i = 0; i<100; i++){
			for(int j = 0; j<100; j++){
				count += map[i][j];
			}
		}
		System.out.println(count);
	}
}