import java.util.*;


class Main{

	static int N;
	static int[][] map;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); 

		map = new int[N][N];

		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				map[i][j] = 0;
			}
		}
	
		int count = 0;
		count+=dfs(0);

		System.out.println(count);

	}

	static int dfs(int row){
		if(row >= N)	return 1;
		int count = 0;
		for(int i = 0; i<N; i++){

			if(!isValid(row, i)) continue;
			
			map[row][i] = 1;
			count += dfs(row+1);	
			map[row][i] = 0;
		}
		
		return count;
	}

	static boolean isValid(int row, int col){
		for(int i = 0; i<N; i++){
			if(map[row][i] == 1)	return false;
			if(map[i][col] == 1)	return false;


			if(row+i < N && col+i < N){
				if(map[row+i][col+i] == 1)	return false;
			}
			if(row+i < N && 0 <= col-i){
				if(map[row+i][col-i] == 1)	return false;
			}
			if(0 <= row-i && col+i < N){
				if(map[row-i][col+i] == 1)	return false;
			}
			if(0 <= row-i && 0 <= col-i){
				if(map[row-i][col-i] == 1)	return false;
			}
		}
		return true;
	}
}
