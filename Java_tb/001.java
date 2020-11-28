import java.util.*;
import java.io.*;


class Main{

	static int N;
	static int M;
	static int K;
	static String[] tokens = new String[28];
	static int[] rows;


	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		rows = new int[N+1];
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for(int i = 1; i<=K; i++){
			tokens[i] = bf.readLine();
		}

		String temp = bf.readLine();
		for(int i = 0; i<N; i++){
			char c = temp.charAt(i);

			int tempIndex = (int)(c - 'A' + 1);
			
			rows[i+1] = tempIndex;
		}

		// END OF INIT
	}

	static void bfs(){


		
	}
}

class Point{
	int x;
	int y;
	Point(x, y){
		this.x = x;
		this.y = y;
	}
}

