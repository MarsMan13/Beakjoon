import java.util.*;
import java.io.*;

class Main{
	
	static int N;
	static int[][] map;
	static int count0 = 0, count1 = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// END OF INIT
		def(N, 0, 0);
		System.out.println(count0);
		System.out.println(count1);
	}

	public static void def(int n, int i, int j){
		int flag = checkAllSame(n, i, j);
		if(flag == 0){
			count0++;
			return;
		}
		else if(flag == 1){
			count1++;
			return;
		}
		def(n/2, i, j);
		def(n/2, i, j+n/2);
		def(n/2, i+n/2, j);
		def(n/2, i+n/2, j+n/2);
	}

	public static int checkAllSame(int n, int i, int j){
		for(int ii = i; ii<i + n; ii++){
			for(int jj = j; jj<j + n; jj++){
				if(map[i][j] != map[ii][jj]){
					return -1;
				}
			}
		}
		return map[i][j];
	}
}