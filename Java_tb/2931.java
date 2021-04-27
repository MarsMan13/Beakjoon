import java.util.*;
import java.io.*;


class Main{
	
	static int R, C;
	static char[][] map = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R+2][C+2];
		for(int i = 0; i<R+2; i++){
			map[i][0] = map[i][C+1] = -1;
		}
		for(int i = 0; i<C+2; i++){
			map[0][i] = map[R+1][i] = -1;
		}
		
		for(int i = 1; i <= R; i++){
			String tempS = bf.readLine();
			for(int j = 1; j <= C; j++){
				map[i][j] = tempS.charAt(j);
			}
		}
		
		// END OF INIT
		
	}

	
}

class Room{
	int[] opened_to = {0, 0, 0, 0};
	int[] opened_from = {0, 0, 0, 0};
	
	Pipe from_up, from_down, from_left, from_right;
	
	Room(char type){
		switch(type){
			case '|':
				from_down = new Pipe(-1, 0);
				from_up = new Pipe(1, 0);
				break;
			case '-':
				from_left = new Pipe(0, 1);
				from_right = new Pipe(0, -1);
				break;
			case '+':
				from_down = new Pipe(-1, 0);
				from_up = new Pipe(1, 0);
				from_left = new Pipe(0, 1);
				from_right = new Pipe(0, -1);
				break;
			case '1':
				break;
			case '2':
				break;
			case '3':
				break;
			case '4':
				break;
		}	
	}
	
	closeAndOpen(char type){
		
	}
	
	class Pipe{
		
		int ii, jj;
	} 
}