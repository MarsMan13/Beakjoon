import java.util.*;
import java.io.*;


class Main{
	
	
	static int N = 0;
	static int[][] space = null;
	static int[][] visited = null;
	
	static int babyShark = 2;
	static int counter = 0;
	static Pair currentPos = null;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		space = new int[N+2][N+2];
		
		for(int i = 1; i<=N; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++){
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j] == 9){
					currentPos = new Pair(i, j, 0);	
					space[i][j] = 0;
				}
			}
		}
		
		// END OF INIT

		while(true){
			visited = new int[N+2][N+2];
			for(int i = 0; i<=N+1; i++){
				visited[i][0] = 1;
				visited[i][N+1] = 1; 
				visited[0][i] = 1;
				visited[N+1][i] = 1;
			}
			List<Pair> eatable = new ArrayList<>();
			Queue<Pair> queue = new LinkedList<>();
			queue.offer(currentPos);
			visited[currentPos.i][currentPos.j] = 1;
			while(!(queue.isEmpty())){
				Pair pos = queue.poll();
				
				for(int i = 0; i<4; i++){
					int new_i = pos.i + ii[i];
					int new_j = pos.j + jj[i];
					if((space[new_i][new_j] == babyShark || space[new_i][new_j] == 0) && visited[new_i][new_j] == 0){
						visited[new_i][new_j] = 1;
						queue.add(new Pair(new_i, new_j, pos.t+1));
					}
					else if(space[new_i][new_j] < babyShark && visited[new_i][new_j] == 0){
						visited[new_i][new_j] = 1;
						eatable.add(new Pair(new_i, new_j, pos.t+1));
					}	
				}	
			}
			if(eatable.isEmpty())
				break;
			Collections.sort(eatable);
			// EAT
			Pair eat = eatable.get(0);
			space[eat.i][eat.j] = 0;
			result += eat.t;
			currentPos = eat;
			counter+=1;
			if(counter == babyShark){
				counter = 0;
				babyShark++;
			}
			eat.t = 0;
		}
		
		System.out.println(result);
		
	}
	
	static int[] ii = {-1, 1, 0, 0};
	static int[] jj = {0, 0, 1, -1};
}

class Pair implements Comparable<Pair>{
	int i, j;
	int t;
	Pair(int i, int j, int t){
		this.i = i; this.j = j;
		this.t = t;
	}
	
	@Override
	public int compareTo(Pair o){
		if(this.t != o.t)
			return this.t - o.t;
		else if(this.i != o.i)
			return this.i - o.i;
		return this.j - o.j;
	}	
}


