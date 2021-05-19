import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static int[][] dist = null;
	static List<Pair> house = new ArrayList<>();
	static List<Pair> chicken = new ArrayList<>();
	static int houseNum, chickenNum;
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++){
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1){		// house
					house.add(new Pair(i, j));
				}
				else if(temp == 2){	// chicken
					chicken.add(new Pair(i, j));
				}
			}
		}
		houseNum = house.size();	chickenNum = chicken.size();
		dist = new int[chickenNum+1][houseNum+1];
		//
		for(int i = 1; i<=chickenNum; i++){
			Pair c = chicken.get(i-1);
			for(int j = 1; j<=houseNum; j++){
				Pair h = house.get(j-1);
				
				int ii = c.i - h.i;
				ii = ii < 0 ? ii * -1 : ii;
				int jj = c.j - h.j;
				jj = jj < 0 ? jj * -1 : jj;
				
				dist[i][j] = ii + jj;
			}
		}
		
		// END OF INIT2
		
		def1(0, 0, new int[M]);
		
		System.out.println(result);
	}
	
	public static void def1(int start, int depth, int[] selected){
		if(depth == M){
			int tot = 0;
			for(int j = 1; j<=houseNum; j++){
				int min = -1;
				for(int i : selected){
					if(min == -1 || dist[i][j] < min)
						min = dist[i][j];
				}
				tot += min;
			}
			if(result == -1 || tot < result)
				result = tot;
			return;
		}
		
		for(int i = start; i<=chickenNum-(M-depth); i++){
			selected[depth] = i+1;
			def1(i+1, depth+1, selected);
		}
	}
}

class Pair{
	int i, j;
	Pair(int i, int j){
		this.i = i;	this.j = j;
	}
}



