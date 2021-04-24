import java.util.*;
import java.io.*;


class Main{
	
	static char[][] map = new char[14][8];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i = 1; i<=12; i++){
			String line = bf.readLine();
			
			for(int j = 1; j<=6; j++){
				map[i][j] = line.charAt(j-1);
			}
		}
	
		//END OF INIT
	
		int step = 0;
		while(bombMap() != 0){
			moveMap();
			step++;
		}
		System.out.println(step);
		
	}

	static void moveMap(){
		int flag = 0;
		do{
			flag = 0;
			for(int i = 13; 0<i; i--){
				for(int j = 1; j<=6; j++){
					if(map[i][j] == '.' && map[i-1][j] != '.' && map[i-1][j] != 0){
						map[i][j] = map[i-1][j];
						map[i-1][j] = '.';
						flag = 1;
					}
				}
			}
		}while(flag == 1);
	}	
	
	
	static int[][] visitedMap = null;
	static int[][] visitedMap2 = null;
	
	static int bombMap(){
		visitedMap = new int[14][8];
		visitedMap2 = new int[14][8];
		int retFlag = 0; 
		for(int i = 1; i<=12; i++){
			for(int j = 1; j<=6; j++){
				int result = 0;
				if(map[i][j] != '.' && visitedMap[i][j] == 0){
					visitedMap[i][j] = 1;
					result += dfs(i, j, map[i][j]);	
				}
				if(4 <= result){
					visitedMap2[i][j] = 1;
					killMap(i, j, map[i][j]);
					retFlag = 1;
				}
			}
		}
		return retFlag;
	}
	
	static void killMap(int i, int j, char target){
		for(int k = 0; k<4; k++){
			int new_i = i+ii[k];
			int new_j = j+jj[k];
			if(visitedMap2[new_i][new_j] == 0 && map[new_i][new_j] == target){
				visitedMap2[new_i][new_j] = 1;
				killMap(new_i, new_j, target);
			}
		}
		map[i][j] = '.';
	}
	
	static int[] ii = {1, -1, 0, 0};
	static int[] jj = {0, 0, 1, -1};
	
	static int dfs(int i, int j, char target){
		int sumOfChild = 0;
		for(int k = 0; k<4; k++){
			int new_i = i+ii[k];
			int new_j = j+jj[k];
			if(visitedMap[new_i][new_j] == 0 && map[new_i][new_j] == target){
				visitedMap[new_i][new_j] = 1;
				sumOfChild += dfs(new_i, new_j, target);
			}
		}
		return 1 + sumOfChild;
	}
}

class Position{
	int i, j;
	Position(int i, int j){
		this.i = i;
		this.j = j;
	}
}










