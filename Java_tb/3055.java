import java.util.*;
import java.io.*;

class Main{
	
	static int[] ii = new int[]{1, -1, 0, 0};
	static int[] jj = new int[]{0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		//
		int[][] map = new int[R+2][C+2];
		int[][] waterMap = new int[R+2][C+2];
		int[][] hamMap = new int[R+2][C+2];
		Queue<Point> queueForHam = new LinkedList<>();
		Queue<Point> queueForWater = new LinkedList<>();
		Point hamInit = null;
		Point endPoint = null;
		 for(int i = 1; i<=R; i++){
			String line = bf.readLine();
			for(int j = 1; j<=C; j++){
				char point = line.charAt(j-1);
				switch(point){
					case 'S':
						map[i][j] = -1;
						hamInit = new Point(i, j, 0);
						break;
					case 'D':
						map[i][j] = -2;
						endPoint = new Point(i, j, 0);
						break;
					case '.':
						map[i][j] = 1000;
						break;
					case '*':
						queueForWater.offer(new Point(i, j, 0));	
						map[i][j] = 1;
						break;
					case 'X':
						map[i][j] = 0;
						break;
				}
			}
		}
		// END OF INIT
		for(int i = 1; i<R+1; i++){
			for(int j = 1; j<C+1; j++){
				hamMap[i][j] = -1;
				waterMap[i][j] = -1;
			}
		}
		if(queueForWater.size() > 0){
			for(Point p : queueForWater){
				waterMap[p.i][p.j] = 0;
			}
			while(!queueForWater.isEmpty()){
				Point cur = queueForWater.poll();
				for(int s = 0; s<4; s++){
					int newI = cur.i + ii[s];
					int newJ = cur.j + jj[s];
					if(waterMap[newI][newJ] == -1 && (map[newI][newJ] == -1 || map[newI][newJ] == 1000)){
						waterMap[newI][newJ] = cur.t+1;
						queueForWater.offer(new Point(newI, newJ, cur.t+1));
					}
				}	
			}
		}
		//
		queueForHam.offer(hamInit);
		hamMap[hamInit.i][hamInit.j] = 0;
		while(!queueForHam.isEmpty()){
			Point cur = queueForHam.poll();
			for(int s = 0; s<4; s++){
				int newI = cur.i + ii[s];
				int newJ = cur.j + jj[s];
				if(hamMap[newI][newJ] == -1 && (cur.t + 1 < waterMap[newI][newJ] || waterMap[newI][newJ] == -1) && map[newI][newJ] != 0){
					hamMap[newI][newJ] = cur.t + 1;
					queueForHam.offer(new Point(newI, newJ, cur.t+1));	
				}
			}
		}
		System.out.println(hamMap[endPoint.i][endPoint.j] == -1 ? "KAKTUS" : hamMap[endPoint.i][endPoint.j]);
	}

}

class Point{
	int i, j, t;
	Point(int i, int j, int t){
		this.i = i;
		this.j = j;
		this.t = t;
	}
}