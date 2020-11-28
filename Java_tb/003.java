import java.util.*;
import java.io.*;



class Main{

	static int N;
	static int[][] data;
	static Point[] point;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(bf.readLine());
		point = new Point[N+1];
		data = new int[N+1][N+1];

		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());

			point = new Point(i+1);
			for(int j = 0; j<N; j++){
				data[i][j] = new int(i, j);
			}
		}

		// END OF INIT

		for(int i = 1; i<=N; i++){
			if(point[i].realVisited == 0){
				dfs(i, 1);
			}
		}

	}

	static int dfs(int index, int count){
	
		if(index)
			
	}
}

class Point{

	int i;
	int realVisited = 0;
	int visited = 0;
	int put = 0;

	Point(int i){
		this.i = i;
	}
}
