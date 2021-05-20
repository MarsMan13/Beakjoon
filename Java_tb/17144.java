import java.util.*;
import java.io.*;


class Main{
	
	static int R, C, T;
	static int[][] map = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
	
		map = new int[R+1][C+1];
		
		for(int i = 1; i<=R; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=C; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
	
		// END OF INIT
	
		
		
	}
}

class Map{
	
	int[][] map = null;
	int R, C;
	int cleanerUp_i, cleanerUp_j;
	int cleanerDown_i, cleanerDown_j;
	
	
	Map(int R, int C, int i, int j, int ii, int jj){
		this.R = R; this.C = C;
		this.cleanerUp_i = i;	this.cleanerUp_j = j;
		this.cleanerDown_i = ii;	this.cleanerDown_j = jj;
		
	}
	
	public void cleanATime(int mode){
		if(mode == 1){			// upper side
		
		}
		else if(mode == -1){	// above side
			
		}
	}
}


