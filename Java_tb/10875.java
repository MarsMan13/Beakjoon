import java.util.*;
import java.io.*;


class Main{

	static int L = 0;
	static int N = 0;
	static Queue<Command> cmd = new LinkedList<>();
	static ArrayList<Position> position = new ArrayList<>();

	static int[] dirX = {0, 1 ,0, -1};
	static int[] dirY = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(bf.readLine());
		N = Integer.parseInt(bf.readLine());

		StringTokenizer st;
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());

			cmd.offer(new Command(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		// END OF INIT

		int x = 0;
		int y = 0;

		long time = 0;

		int dir = 0;	
		// 0 --> +y, 1 --> +x, 2 --> -y, 3 --> -x
		Command temp = null;
		position.add(new Position(x, y));
outer:
		while(!(cmd.isEmpty())){
			temp = cmd.poll();
			
			for(int i = 0; i<temp.t; i++){
				x += dirX[dir];
				y += dirY[dir];
				time++;
				if(die(x, y)){
					break outer;	
				}
				position.add(new Position(x, y));

			}

			if(temp.dir == 1)
				dir--;
			else if(temp.dir == 2)
				dir++;

			if(dir == -1)
				dir = 3;
			else if(dir == 4)
				dir = 0;
		}
	
		while(!die(x,y)){
			x += dirX[dir];
			y += dirY[dir];
			time++;
		}

		System.out.println(time);

	}

	static boolean die(int x, int y){

		if(x < -1 *L || L < x || y < -1 *L || L < y){
			return true;
		}

		Position temp = new Position(x, y);

		Collections.sort(position);
		int pos = Collections.binarySearch(position, temp);
		if(pos < 0)
			return false;
		return true;
	}

}

class Position implements Comparable<Position>{

	int x;
	int y;

	Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Position obj){
		if(this.x != obj.x)
			return this.x - obj.x;
		else
			return this.y - obj.y;
	}

}

class Command{

	int t;
	int dir;	// L : 1, R : 2

	Command(int t, int dir){
		this.t = t;
		this.dir = dir;
	}

	Command(int t, String dir){
		this.t = t;
		if(dir.equals("L")){
			this.dir = 1;
		}
		else if(dir.equals("R")){
			this.dir = 2;
		}
	}
}
