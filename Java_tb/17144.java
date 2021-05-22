import java.util.*;
import java.io.*;


class Main{
	
	static int R, C, T;
	static Map map = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
	
		map = new Map(R, C);
		
		int flag = 0;
		int[] cp = new int[2];
		for(int i = 1; i<=R; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=C; j++){
				map.map[i][j] = Integer.parseInt(st.nextToken());
				if(map.map[i][j] == -1)
					cp[flag++] = i;
					
			}
		}
		map.init(cp[0], 1, cp[1], 1);
		// END OF INIT

		
		for(int t = 0; t<T; t++){
			map.spreadDust();
			map.cleanerATime();
		}
	
		int ret = 0;
		for(int i = 1; i<=map.R; i++){
			for(int j = 1; j<=map.C; j++){
				if(0 < map.map[i][j]){
					ret += map.map[i][j];
				}
			}
		}
		System.out.println(ret);
		
	}
}

class Map{
	
	static int[] ii = new int[]{1, -1, 0, 0};
	static int[] jj = new int[]{0, 0, 1, -1};
	
	int[][] map = null;
	int R, C;
	int cleanerUp_i, cleanerUp_j;
	int cleanerDown_i, cleanerDown_j;
	int[] upInfo = null;	int[] downInfo = null;
	
	
	Map(int R, int C){
		this.R = R; this.C = C;
		this.map = new int[R+2][C+2];
		for(int i = 0; i<=R+1; i++)
			map[i][0] = map[i][C+1] = -1;
		for(int j = 0; j<=C+1; j++)
			map[0][j] = map[R+1][j] = -1;
	}
	
	public void init(int i, int j, int ii, int jj){
		this.cleanerUp_i = i;	this.cleanerUp_j = j;
		this.cleanerDown_i = ii;	this.cleanerDown_j = jj;
	}
	
	public void spreadDust(){
		
		int[][] map2 = new int[R+1][C+1];
		
		for(int i = 1; i<=R; i++){
			for(int j = 1; j<=C; j++){
				if(map[i][j] > 0){
					int count = 0;
					for(int s = 0; s<4; s++){
						int new_i = i + ii[s];	int new_j = j + jj[s];
						if(map[new_i][new_j] >= 0){	// spreaded
							map2[new_i][new_j] += map[i][j] / 5;
							count++;
						}
					}
					map2[i][j] += map[i][j] - (map[i][j] / 5 * count); 
				}
			}
		}
		for(int i = 1; i<=R; i++){
			for(int j = 1; j<=C; j++)
				map[i][j] = map2[i][j];
		}
		map[cleanerUp_i][cleanerUp_j] = map[cleanerDown_i][cleanerDown_j] = -1;
	}
	
	public void cleanerATime(){
	
		{
			int j = 1;
			for(int i = cleanerUp_i-2; 0<i; i--){
				map[i+1][j] = map[i][j];
			}
		}	
		{
			int i = 1;
			for(int j = 2; j<=C; j++){
				map[i][j-1] = map[i][j];
			}
		}	
		{
			int j = C;
			for(int i = 2; i<=cleanerUp_i; i++){
				map[i-1][j] = map[i][j];
			}
		}	
		{
			int i = cleanerUp_i;
			for(int j = C-1; 1 < j; j--){
				map[i][j+1] = map[i][j];
			}
			map[cleanerUp_i][2] = 0;
		}	
		
		{
			int j = 1;
			for(int i = cleanerDown_i+2; i<=R; i++){
				map[i-1][j] = map[i][j];
			}
		}	
		{
			int i = R;
			for(int j = 2; j<=C; j++){
				map[i][j-1] = map[i][j];
			}
		}	
		{
			int j = C;
			for(int i = R-1; cleanerDown_i<=i; i--){
				map[i+1][j] = map[i][j];
			}
		}	
		{
			int i = cleanerDown_i;
			for(int j = C-1; 1 < j; j--){
				map[i][j+1] = map[i][j];
			}
			map[cleanerDown_i][2] = 0;
		}	
	}
	
	public void printMap(){
		for(int i = 1; i<=R; i++){
			for(int j = 1; j<=C; j++)
				System.out.print(map[i][j] +" ");
			System.out.println();
		}
		System.out.println("======");
	}
}






