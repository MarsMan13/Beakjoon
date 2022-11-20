import java.util.*;
import java.io.*;

class Main{
	
	static int H, W;
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		H = Integer.parseInt(st.nextToken());	W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		//
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			int type = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			int[] pair = getRowCol(type, dist);

		}
	}

	static int[] getRowCol(int type, int dist){
		switch(type){
			case 1:
				return new int[]{0, dist};
			case 2:
				return new int[]{H-1, dist};
			case 3:
				return new int[]{0, dist};
			case 4:
				return new int[]{W-1, dist};
		}
		return null;
	}
}
