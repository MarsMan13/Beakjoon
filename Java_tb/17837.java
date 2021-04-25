import java.util.*;
import java.io.*;



class Main{		// class Map
	
	static int N, K;
	static int[][] map = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		map = new int[N+2][N+2];
		for(int i = 0; i<=N+1; i++){
			map[0][i] = map[N+1][i] = map[i][0] = map[i][N+1] = 2;
		}
		Horse.initHorseMap(N);
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 
		for(int i = 0; i<K; i++){
			st = new StringTokenizer(bf.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			//
			Horse newH = new Horse(i+1, row, col, dir);	
		}
		int count = 0;
		outer: do{
			count++;
			for(int i = 0; i<K; i++){
				Horse temp = Horse.horses.get(i);
				if(temp.moveHorse() == 1){
					break outer;	
				}
				System.out.println("=============");
				temp.printMap();
			}

		}while(count <= 1000);
		if(1000 < count)
			System.out.println(-1);
		else
			System.out.println(count);
	}

}

class Horse{
	
	static ArrayList<Horse>[][] horseMap = null;
	static List<Horse> horses = new ArrayList<>();
	
	int index;
	int i, j;
	int dir;
	
	List<Horse> upper = new ArrayList<>();
	
	public int moveHorse(){
		int new_i = this.i + ii[dir];
		int new_j = this.j + jj[dir];
		int color = Main.map[new_i][new_j];
		if(color == 0 || color == 1){
			jumpTogether(color);
		}
		else if(color == 2){
			switch(dir){
				case 1:
					dir = 2;
					break;
				case 2:
					dir = 1;
					break;
				case 3:
					dir = 4;
					break;
				case 4:
					dir = 3;
					break;
			}
			new_i = this.i + ii[dir];
			new_j = this.j + jj[dir];
			color = Main.map[new_i][new_j];
			if(color == 0 || color == 1){
				jumpTogether(color);
			}
		}
		if(4 <= horseMap[i][j].size())
			return 1;
		return 0;
	}
	
	public void jumpTogether(int mode){
		int new_i = this.i + ii[dir];
		int new_j = this.j + jj[dir];
		
		int flag = 0;
		List<Horse> targets = new LinkedList<>();
		for(int row = 0; row < horseMap[i][j].size(); row++){	
			if(horseMap[i][j].get(row).index == this.index || flag == 1){
				flag = 1;
				Horse target = horseMap[i][j].get(row);
				if(mode == 0){
					targets.add(target);
				}
				else if(mode == 1){
					targets.add(0, target);
				}
				target.i = new_i;
				target.j = new_j;
			}
		}
		horseMap[i][j].removeAll(targets);
		horseMap[new_i][new_j].addAll(targets);
		// for(Horse h : targets){
		// 	h.i = new_i;
		// 	h.j = new_j;
		// }
		// for(Horse h : targets){
		// 	System.out.print("("+h.i+", "+h.j+")");
		// }
		// System.out.println();
	}
	
	public Horse(int index, int i, int j, int dir){
		this.index = index;
		this.i = i; this.j = j;
		this.dir = dir;
		horses.add(this);
		horseMap[i][j].add(this);
	}
	
	static ArrayList<Horse>[][] initHorseMap(int N){
		horseMap = new ArrayList[N+2][N+2];
		for(int i = 1; i<=Main.N; i++){
			for(int j = 1; j<=Main.N; j++){
				horseMap[i][j] = new ArrayList<>();
			}
		}
		return horseMap;
	}
	
	static int finCheck(){
		
		for(int i = 1; i<=Main.N; i++){
			for(int j = 1; j<=Main.N; j++){
				List<Horse> targets = horseMap[i][j];
				if(4 <= targets.size())
					return 1;
			}
		}
		
		return 0;
	}

	static void printMap(){
		for(int i = 1; i<=Main.N; i++){
			for(int j = 1; j<=Main.N; j++){
				System.out.print(horseMap[i][j].size() + " ");
			}
			System.out.println("\n");
		}
	}
	
	static int[] ii = {0, 0, 0, -1, 1};
	static int[] jj = {0, 1, -1, 0, 0};
	
	@Override
	public String toString(){
		return this.index +""; 
	}
}
