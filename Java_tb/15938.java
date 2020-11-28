import java.util.*;
import java.io.*;



class Main{

	static int T;
	
	static final int originX = 200;
	static final int originY = 200;

	static int targetX;
	static int targetY;
	static int[][] ban = new int[401][401];

	static int[] dx = new int[]{1, -1, 0, 0};
	static int[] dy = new int[]{0, 0, 1, -1};

	static long count = 0;

	public static void main(String[] args) throws IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int x = Integer.parseInt(st.nextToken()) + originX;
		int y = Integer.parseInt(st.nextToken()) + originY;

		T = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());

		targetX = Integer.parseInt(st.nextToken()) + originX;
		targetY = Integer.parseInt(st.nextToken()) + originY;
		
		int k = Integer.parseInt(bf.readLine());
		for(int i = 0; i<k; i++){
			st = new StringTokenizer(bf.readLine());
			int xx = Integer.parseInt(st.nextToken());
			int yy = Integer.parseInt(st.nextToken());

			if(xx > 200 || xx < -200)
				continue;
			if(yy > 200 || yy < -200)
				continue;

			ban[xx+originX][yy+originY] = 1; 
		}

		bfs(x, y);
	
		System.out.println(count);
		
	}

	static void bfs(int x, int y){

		Point root = new Point(x, y, 0);
		Queue<Point> queue = new LinkedList<>();
		queue.offer(root);
		while(!(queue.isEmpty())){
			Point temp = queue.poll();

			int tempX = temp.x;
			int tempY = temp.y;
			int tempT = temp.t;
			
			if(tempX == targetX && tempY == targetY){
				count++;
				count %= 1000000007;
			}
			else if((T - tempT) >= (Math.abs(tempX - targetX) + Math.abs(tempY - targetY))){
				for(int i = 0; i<4; i++){
					int newX = tempX + dx[i];
					int newY = tempY + dy[i];
					if(newX < -200+originX || newX > 200+originX || newY < -200+originY || newY > 200+originY)
						continue;
					if(ban[newX][newY] == 1)
						continue;
					queue.offer(new Point(newX, newY, tempT+1));
				}
			}
		}

	}
}

class Point{
	int x;
	int y;
	long t;
	Point(int x, int y, long t){
		this.x = x;
		this.y = y;
		this.t = t;
	}
}
