import java.util.*;
import java.io.*;


class Main{
	
	static int R, C;
	static Room[][] map = null;
	static int M_i, M_j	;
	static int Z_i, Z_j;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new Room[R+2][C+2];
		
		for(int i = 1; i <= R; i++){
			String tempS = bf.readLine();
			for(int j = 1; j <= C; j++){
				char tempC = tempS.charAt(j-1);
				if(tempC == 'M'){
					M_i = i; M_j = j;
					map[i][j] = new Room(i, j, '+');
				}
				else if(tempC == 'Z'){
					Z_i = i; Z_j = j;
					map[i][j] = new Room(i, j, '+');
				}
				else if(tempC != '.'){
					map[i][j] = new Room(i, j, tempC);	
				}
			}
		}
	
		// END OF INIT
		
		int Mpi = 0; 	int Mpj = 0;
		for(int i = 0; i<4; i++){
			if(map[M_i+ii[i]][M_j+jj[i]] != null){
				Mpi = M_i + ii[i];
				Mpj = M_j + jj[i];
			}
		}
		// END OF FINDING STARTING ROOM
		
		Pipe pp1 = null;
		{
			int gap_i = Mpi - M_i;
			int gap_j = Mpj - M_j;
			Pipe tempPipe = new Pipe(M_i, M_j, gap_i, gap_j);
			pp1 = tempPipe.getNextPipe();
		}
	
		pp1 = def1(pp1, 0);
		int next_i = pp1.getNext_i();
		int next_j = pp1.getNext_j();
		int max = -1;
		
		char answer_c = 0;
		for(char b : blocks){
			map[next_i][next_j] = new Room(next_i, next_j, b);
			Pipe ret = def1(pp1, 0);
			if(ret.ii == -13){
				if(max == -1 || max < ret.jj){
					max = ret.jj;
					answer_c = b;
				}
			}
		}
		
		System.out.println(next_i + " " + next_j + " " + (char)answer_c);
		
	}

	static int answer_i = 0, answer_j = 0;
	static char answer_c = 0;
	
	static Pipe def1(Pipe pp, int counter){

		if(pp.i == Z_i && pp.j == Z_j)
			return new Pipe(0, 0, -13, counter);
		Pipe next_pipe = pp.getNextPipe();

		if(next_pipe == null){
			return pp;
		}
		return def1(next_pipe, counter+1);
	}

	static char[] blocks = {'|', '-', '+', '1', '2', '3', '4'};
	
	static int[] ii = {1, -1, 0, 0};
	static int[] jj = {0, 0, 1, -1};
	
}

class Room{

	int i, j;
	Pipe from_up = null, from_down = null, from_left = null, from_right = null;	
	// each id: 1, 2, 3, 4
	
	Room(int i, int j){
		this.i = i; this.j = j;
	}
	
	Room(int i, int j, char type){
		this.i = i; this.j = j;
		switch(type){
			case '|':
				from_down = new Pipe(i, j, -1, 0);
				from_up = new Pipe(i, j, 1, 0);
				break;
			case '-':
				from_left = new Pipe(i, j, 0, 1);
				from_right = new Pipe(i, j, 0, -1);
				break;
			case '+':
				from_down = new Pipe(i, j, -1, 0);
				from_up = new Pipe(i, j, 1, 0);
				from_left = new Pipe(i, j, 0, 1);
				from_right = new Pipe(i, j, 0, -1);
				break;
			case '1':
				from_right = new Pipe(i, j, 1, 0);
				from_down = new Pipe(i, j, 0, 1);
				break;
			case '2':
				from_up = new Pipe(i, j, 0, 1);
				from_right = new Pipe(i, j, -1, 0);
				break;
			case '3':
				from_left = new Pipe(i, j, -1, 0);
				from_up = new Pipe(i, j, 0, -1);
				break;
			case '4':
				from_left = new Pipe(i, j, 1, 0);
				from_down = new Pipe(i, j, 0, -1);
				break;
		}
	}
	
}

class Pipe{

	int i, j;
	int ii, jj;

	Pipe nextRoom = null;
	
	Pipe(int i, int j, int ii, int jj){
		this.i = i; 	this.j = j;
		this.ii = ii;	this.jj = jj;
	}

	Room getNextRoom(){
		return Main.map[i+ii][j+jj];
	}
	
	Pipe getNextPipe(){
		Room nextRoom = getNextRoom();
		if(nextRoom == null)
			return null;
		// else
		if(ii == 0){
			if(jj == 1)
				return nextRoom.from_left;
			else if(jj == -1)
				return nextRoom.from_right;
		}
		else if(ii == 1)		// jj = 0
			return nextRoom.from_up;
		else if(ii == -1)	// jj = 0
			return nextRoom.from_down;
		return null;
		
	}
	
	int getNext_i(){
		return i+ii;
	}
	
	int getNext_j(){
		return j+jj;
	}
} 
