import java.util.*;
import java.io.*;

class Main{

	static int[][] map;
	static int N, M;
	static int sum = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//
		for(int r = 0; r<4; r++){
			for(int f = 0; f<2; f++){
				for(int t = 0; t<5; t++){
					for(int i = 0; i<N; i++){
						for(int j = 0; j<M; j++){
							int tempSum = 0;
							for(int s = 0; s<4; s++){
								int newI = i + ii[t][s];
								int newJ = j + jj[t][s];
								if(0<=newI && newI <N && 0<=newJ && newJ <M){
									tempSum += map[newI][newJ];
								}
								else{
									tempSum -= 100000;
									break;
								}
							}
							if(sum < tempSum)	sum = tempSum;
						}
					}
				}
				flipMap();	
			}
			rotateMap();
		}
		System.out.println(sum);
	}

	public static void flipMap(){
		int[][] newMap = new int[N][M];
		for(int i = 0; i<N; i++){
			for(int j = 0; j<M; j++){
				newMap[i][M - j - 1] = map[i][j];
			}
		}
		map = newMap;
	}

	public static void rotateMap(){
		int[][] newMap = new int[M][N];
		for(int i = 0; i<N; i++){
			for(int j = 0; j<M; j++){
				newMap[j][N - i - 1] = map[i][j];
			}
		}
		map = newMap;
		int temp = N;
		N = M;
		M = temp;
	}
/* . j
	i*
	 ****
*/
	static int[][] ii = {
		{0,0,0,0},
		{0,0,1,1},
		{0,1,2,2},
		{0,1,1,2},
		{0,0,0,1},
	};
	static int[][] jj = {
		{0,1,2,3},
		{0,1,0,1},
		{0,0,0,1},
		{0,0,1,1},
		{0,1,2,1},
	};
}