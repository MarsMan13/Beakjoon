import java.util.*;
import java.io.*;


class Main{

	static long L = 0;
	static long N = 0;
	static Queue<Command> cmd = new LinkedList<>();
	static ArrayList<Position> position = new ArrayList<>();

	static long back = -1;
	static long dir = 1;
	static long flag2 = 0;

	static long[] dirX = {0, 1 ,0, -1};
	static long[] dirY = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(bf.readLine());
		N = Integer.parseInt(bf.readLine());

		StringTokenizer st;
		for(long i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());

			cmd.offer(new Command(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		// END OF INIT

		long x = 0;
		long y = 0;
		long flag = 0;
		long time = 0;

		// 0 --> +y, 1 --> +x, 2 --> -y, 3 --> -x
		Command temp = null;
		position.add(new Position(x, y));

outer:
		while(!(cmd.isEmpty())){
			temp = cmd.poll();
			
			x += (dirX[(int)dir]*temp.t);
			y += (dirY[(int)dir]*temp.t);
			time += temp.t;
			position.add(new Position(x, y));
			if(die(x, y)){
				if(flag2 == 1){
					time -= temp.t;
					System.out.println("time: "+time+" back: "+back);
					time += back;
				}
				else{
					time-=back;
				}
				flag = 1;
				break outer;	
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


		// change!

		while(flag == 0 && !die(x,y)){
			x += dirX[(int)dir];
			y += dirY[(int)dir];
			position.add(new Position(x, y));
			time++;
		}

		System.out.println(time);

	}

	static boolean die(long x, long y){
		long size = position.size();


		if(3 <= size){
			long xx1 = position.get((int)size-1).x;
			long yy1 = position.get((int)size-1).y;
			long xx2 = position.get((int)size-2).x;
			long yy2 = position.get((int)size-2).y;


			long type1 = -1;
			if(xx1 == xx2)		type1 = 1;
			else if(yy1 == yy2)	type1 = 2;
			//int type1 = (x1 == x2) ? 1 : 2;	// 1 --> x1 == x2, 2 --> y1 == y2

			long preX = position.get((int)size-3).x;
			long preY = position.get((int)size-3).y;
			long curX= 0;
			long curY= 0;
			long type2 = -1;
		
			for(long i = size-4; 0<=i; i--){
				long backTemp = 0;
				long x1 = xx1;
				long y1 = yy1;
				long x2 = xx2;
				long y2 = yy2;
				curX = position.get((int)i).x;
				curY = position.get((int)i).y;

				type2 = (curX == preX) ? 1 : 2;

				if(type1 == 1){
					if(type2 == 1){
						if((x1 == curX) && ((y1-preY)*(y2-preY) <= 0 || (y1-curY)*(y2-curY) <= 0)){
							while(!(y2 == curY) && !(y2 == preY)){
								y2+=dirY[(int)dir];
								backTemp++;
							}
							flag2 = 1;
							if(back == -1 || backTemp < back){
								back = backTemp;
							}
						}
					}
					else if(type2 == 2){
						if(((curX - x1)*(preX - x1) <= 0) && (y1-curY)*(y2-curY) <= 0){
							while(!(y2 == curY)){
								y2+=dirY[(int)dir];
								backTemp++;
							}
							flag2 = 1;
							if(back == -1 || backTemp < back){
								back = backTemp;
							}
						}
					}	
				}
				else if(type1 == 2){
					if(type2 == 1){
						if(((x1 - curX)*(x2 - curX) <= 0) && (curY - y1)*(preY - y1) <= 0){
							while(!(x2 == curX)){
								x2+=dirX[(int)dir];
								backTemp++;
							}
							flag2 = 1;
							if(back == -1 || backTemp < back){
								back = backTemp;
							}
						}

					}
					else if(type2 == 2){
						if((y1 == curY) && ((x1-preX)*(x2-preX) <= 0 || (x1-curX)*(x2-curX) <= 0)){
							//System.out.println("dir: "+dir+" curX: "+curX+" preX: "+preX+" x1: "+x1);
							while(!(x2 == curX) && !(x2 == preX)){
								x2+=dirX[(int)dir];
								backTemp++;
							}
							flag2 = 1;
							if(back == -1 || backTemp < back){
								back = backTemp;
							}
						}
					}
				}

				preX = curX;
				preY = curY;
			}

			if(flag2 == 1){
				return true;
			}

		}
	
		if(x < -1*L){
			while((x < -1*L)){
				x++;
				back++;
			}
			return true;
		}
		else if(L < x){
			while((L < x)){
				x--;
				back++;
			}
			return true;
		}
		else if(y < -1*L){
			while((y < -1*L)){
				y++;
				back++;
			}
			return true;
		}
		else if(L < y){
			while((L < y)){
				y--;
				back++;
			}
			return true;
		}

		return false;
		
	}

}

class Position{

	long x;
	long y;

	Position(long x, long y){
		this.x = x;
		this.y = y;
	}
}

class Command{

	long t;
	int dir;	// L : 1, R : 2

	Command(long t, int dir){
		this.t = t;
		this.dir = dir;
	}

	Command(long t, String dir){
		this.t = t;
		if(dir.equals("L")){
			this.dir = 1;
		}
		else if(dir.equals("R")){
			this.dir = 2;
		}
	}
}
