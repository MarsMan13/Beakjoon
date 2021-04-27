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
					map[i][j] = new Room(i, j, '+');
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
		
		int flag2 = 0;
		int pointer_i = M_i; int pointer_j = M_j;
		for(int i = 0; i<4; i++){
			if(map[M_i+ii[i]][M_j+jj[i]] != null){
				pointer_i = M_i + ii[i];
				pointer_j = M_j + jj[i];
				flag2 = 1;
			}
		}
		
		if(flag2 == 0){
			int temp = 0;
			
			temp = M_i;
			M_i = Z_i;
			Z_i = temp;
			temp = M_j;
			M_j = Z_j;
			Z_j = temp;
			pointer_i = M_i; pointer_j = M_j;
			for(int i = 0; i<4; i++){
				if(map[M_i+ii[i]][M_j+jj[i]] != null){
					pointer_i = M_i + ii[i];
					pointer_j = M_j + jj[i];
					flag2 = 1;
				}
			}
		}
		
		// END OF FINDING STARTING ROOM
		
		Pipe pointer_pipe = null;
		{
			int gap_i = pointer_i - M_i;
			int gap_j = pointer_j - M_j;
			Pipe tempPipe = new Pipe(gap_i, gap_j);
			int nextPipeType = tempPipe.getNext();
			pointer_pipe = map[M_i][M_j].pipes[nextPipeType];
		}
	
		def1(pointer_pipe, 0);
		System.out.println(answer_i + " " + answer_j + " " + (char)answer_c);
		
	}

	static int answer_i = 0, answer_j = 0;
	static char answer_c = 0;
	
	static int def1(Pipe pointer_pipe, int flag){

		if(pointer_pipe.i == Z_i && pointer_pipe.j == Z_j)
			return 1;
	
		Pipe next_pipe = pointer_pipe.getNextPipe();

		if(next_pipe == null){
			if(flag == 1){
				return 0;
			}
			int ret = 0;
			int target_i = pointer_pipe.getNext_i();
			int target_j = pointer_pipe.getNext_j();
			for(int b = 0; b < blocks.length; b++){
				map[target_i][target_j] = new Room(target_i, target_j, blocks[b]);
				ret = def1(pointer_pipe, 1);
				if(ret == 0){
					map[target_i][target_j] = null;
				}
				else if(ret == 1){
					answer_i = target_i;
					answer_j = target_j;
					answer_c = blocks[b];
					return 1;
				}
			}	
		}
		return def1(next_pipe, flag);
	}

	static char[] blocks = {'|', '-', '+', '1', '2', '3', '4'};
	
	static int[] ii = {1, -1, 0, 0};
	static int[] jj = {0, 0, 1, -1};
	
}

class Room{

	int i, j;
	Pipe[] pipes = new Pipe[5];
	Pipe from_up = null, from_down = null, from_left = null, from_right = null;	
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
				from_left = new Pipe(1, 0);
				from_down = new Pipe(0, -1);
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
