import java.util.*;
import java.io.*;


class Main{

	static int M;
	static int N;
	static int V;

	static int resultH = -1;
	static int resultT = 0;

	static Point[][] map = new Point[101][101];

	public static void main(String[] args) throws IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		for(int i = 1; i<=M; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++){
				map[i][j] = new Point(i, j, Integer.parseInt(st.nextToken())); 
			}
		}

		for(int i = 0; i<V; i++){
			st = new StringTokenizer(bf.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[a][b].ok = false;
			map[a][b].time = c;
		}

		// END OF INIT

		int time = 0;
		
		Queue<Point> queue = new LinkedList<>();
		map[x][y].no = 0;
		map[x][y].ok = false;
		queue.offer(map[x][y]);
		while(!(queue.isEmpty())){

			Point temp = queue.poll();
			time = temp.no;
			if(resultH < temp.height){
				resultH = temp.height;
				resultT = time;
			}
			
			coverMap(time);
			
			if(1 <=temp.x-1 && map[temp.x-1][temp.y].ok){
				map[temp.x-1][temp.y].no = time+1;
				map[temp.x-1][temp.y].ok = false;
				queue.offer(map[temp.x-1][temp.y]);	
			}
			if(1 <=temp.y-1 && map[temp.x][temp.y-1].ok){
				map[temp.x][temp.y-1].no = time+1;
				map[temp.x][temp.y-1].ok = false;
				queue.offer(map[temp.x][temp.y-1]);	
			}
			if(temp.x+1<=M && map[temp.x+1][temp.y].ok){
				map[temp.x+1][temp.y].no = time+1;
				map[temp.x+1][temp.y].ok = false;
				queue.offer(map[temp.x+1][temp.y]);	
			}
			if(temp.y+1<=N && map[temp.x][temp.y+1].ok){
				map[temp.x][temp.y+1].no = time+1;
				map[temp.x][temp.y+1].ok = false;
				queue.offer(map[temp.x][temp.y+1]);	
			}
			

		}

		System.out.println("" + resultH+ " " + resultT);
	}

	static void coverMap(int time){
		for(int i = 1; i<=M; i++){
			for(int j = 1; j<=N; j++){
				if(map[i][j].ok == false && map[i][j].time == time){
					if(1 <= i-1){
						map[i-1][j].ok = false;
						map[i-1][j].time = time+1;
					}
					if(1 <= j-1){
						map[i][j-1].ok = false;
						map[i][j-1].time = time+1;
					}
					if(i+1 <= M){
						map[i+1][j].ok = false;
						map[i+1][j].time = time+1;
					}
					if(j+1 <= N){
						map[i][j+1].ok = false;
						map[i][j+1].time = time+1;
					}
				}
			}
		}
	}
}

class Point{

	int x;
	int y;
	int height;
	boolean ok = true;
	int time = -1;
	int no = 0;

	Point(int x, int y, int h){
		this.x = x;
		this.y = y;
		this.height = h;
	}

	@Override
	public String toString(){
		return "x: " + x + ", y: " + y;
	}
}

