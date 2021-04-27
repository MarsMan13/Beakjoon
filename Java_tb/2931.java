import java.util.*;
import java.io.*;


class Main{
	
	static int R, C;
	static Room[][] map = null;
	static int M_i, M_j;
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
				}
				else if(tempC == 'Z'){
					Z_i = i; Z_j = j;
					map[i][j] = new Room(i, j, '+');
				}
				else if(tempC != '.')
					map[i][j] = new Room(i, j, tempC);	
			}
		}
		
		// END OF INIT
		
		int pointer_i = M_i; int pointer_j = M_j;
		int pointer_d = -1;
		Room pointer_room = null;
		for(int i = 0; i<4; i++){
			if(map[pointer_i+ii[i]][pointer_j+jj[i]] != null){
				pointer_i = pointer_i + ii[i];
				pointer_j = pointer_j + jj[i];
				pointer_room = map[pointer_i][pointer_j];	
			}
		}
		
		// END OF FINDING STARTING ROOM
		
		{
			int gap_i = pointer_i - M_i;
			int gap_j = pointer_j - M_j;
			
			Pipe tempPipe = new Pipe(gap_i, gap_j);
			tempPipe.i = pointer_i;	tempPipe.j = pointer_j;
			pointer_d = tempPipe.getNext();
		}
	
		int counter = 0;
		Pipe pointer_pipe = pointer_room.pipes[pointer_d];
		
		while(pointer_pipe.i != Z_i || pointer_pipe.j != Z_j){
			pointer_pipe = pointer_pipe.getNextPipe();
			counter++;
		}
	
		System.out.println(counter);
		
	}
	
	int def1(Pipe pointer_pipe){
	
		while(pointer_pipe.i != Z_i || pointer_pipe.j != Z_j){
			pointer_pipe = pointer_pipe.getNextPipe();
			
		}
		
		
		return 0;
	}

	static int[] ii = {1, -1, 0, 0};
	static int[] jj = {0, 0, 1, -1};
	
}

class Room{

	int i, j;
	Pipe[] pipes = new Pipe[5];
	Pipe from_up, from_down, from_left, from_right;	
	// each id: 1, 2, 3, 4
	
	Room(int i, int j, char type){
		this.i = i; this.j = j;
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
				from_right = new Pipe(1, 0);
				from_down = new Pipe(0, 1);
				break;
			case '2':
				from_up = new Pipe(0, 1);
				from_right = new Pipe(-1, 0);
				break;
			case '3':
				from_left = new Pipe(-1, 0);
				from_up = new Pipe(0, -1);
				break;
			case '4':
				from_up = new Pipe(1, 0);
				from_down = new Pipe(-1, 0);
				break;
		}
		pipes[1] = from_up; 	pipes[4] = from_right;
		pipes[2] = from_down; 	pipes[3] = from_left;
		for(int k = 1; k<=4; k++){
			if(pipes[k] == null)
				continue;
			pipes[k].i = this.i;
			pipes[k].j = this.j;
		}
	}
	
}

class Pipe{

	int i, j;
	int ii, jj;

	Pipe nextRoom = null;
	
	Pipe(int ii, int jj){
		this.ii = ii;	this.jj = jj;
	}

	Room getNextRoom(){
		return Main.map[i+ii][j+jj];
	}
	
	Pipe getNextPipe(){
		Room nextRoom = getNextRoom();
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

	int getNext(){
		if(ii == 0){
			if(jj == 1)
				return 3;
			else if(jj == -1)
				return 4;
		}
		else if(ii == 1)		// jj = 0
			return 1;
		else if(ii == -1)	// jj = 0
			return 2;
		return 0;
	}

} 
