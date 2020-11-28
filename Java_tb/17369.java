import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;


class Main{

	static Node[] Ls;
	static Node[] Rs;
	static Node[] Us;
	static Node[] Ds;

	static int[][] results;

	public static void main(String[] args) throws Exception {
		new Main();
	}

	Main() throws Exception {
		int N,M,K,Q;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] tempStrs = bf.readLine().split(" ");
		N = Integer.parseInt(tempStrs[0]);
		M = Integer.parseInt(tempStrs[1]);
		K = Integer.parseInt(tempStrs[2]);
		Q = Integer.parseInt(tempStrs[3]);

		Ls = new Node[N+1];
		Rs = new Node[N+1];
		results = new int[2][Q+1];
		for(int i = 1; i<=N; i++){
			Ls[i] = new Node(i, 0, 4);
			Rs[i] = new Node(i, M+1, 4);
			Ls[i].right = Rs[i];
			Rs[i].left = Ls[i];
		}

		Us = new Node[M+1];
		Ds = new Node[M+1];
		for(int i = 1; i<=M; i++){
			Us[i] = new Node(0, i, 4);
			Ds[i] = new Node(N+1, i, 4);
			Us[i].down = Ds[i];
			Ds[i].up = Us[i];
		}
		//
		//
		for(int i = 0; i<K; i++){
			tempStrs = bf.readLine().split(" ");
			int tempRow = Integer.parseInt(tempStrs[0]);
			int tempCol = Integer.parseInt(tempStrs[1]);
			int tempType = 4;
			switch(tempStrs[2]){
				case "/":
					tempType = 1;
					break;
				case "\\":
					tempType = 2;
					break;
				case "!":
					tempType = 3;
					break;
			}

			Node tempNode = new Node(tempRow, tempCol, tempType);
			tempNode.insert();

		}

		//
		for(int i = 0; i<Q; i++){
			String tempStr = bf.readLine();
			int direction = 4;
			switch(tempStr.substring(0,1)){
				case "L":
					direction = 1;
					break;
				case "U":
					direction = 2;
					break;
				case "R":
					direction = 3;
					break;
				case "D":
					direction = 4;
					break;
			}

			travel(direction, Integer.parseInt(tempStr.substring(1)), i);

		}

		StringBuilder sb = new StringBuilder();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i = 0; i<Q; i++){
			sb.append(results[0][i]);
			sb.append(" ");
			sb.append(results[1][i]);
			sb.append("\n");
		}
		bw.write(sb.toString());

		bf.close();
		bw.close();
	}

	void travel(int direction, int index, int no){
		Node start = null;
		int count = 0;
		int steps = 0;
		int length = 0;
		int preIndex = 0;

		switch(direction){
			case 1:
				start = Ls[index];
				preIndex = start.col;
				break;
			case 2:
				start = Us[index];
				preIndex = start.row;
				break;
			case 3:
				start = Rs[index];
				preIndex = start.col;
				break;
			case 4:
				start = Ds[index];
				preIndex = start.row;
				break;
		}
		
		boolean isStart = true;
		while(isStart || start.type != 4){
			isStart = false;
	
			switch(direction){
				case 1:
					steps += Math.abs(preIndex - start.col);
					break;
				case 2:
					steps += Math.abs(preIndex - start.row);
					break;
				case 3:
					steps += Math.abs(preIndex - start.col);
					break;
				case 4:
					steps += Math.abs(preIndex - start.row);
					break;
			}

			switch(start.type){
				case 1:
					if(direction == 1)		direction = 4;
					else if(direction == 2)	direction = 3;
					else if(direction == 3) direction = 2;
					else if(direction == 4) direction = 1;
					break;
				case 2:
					if(direction == 1)		direction = 2;
					else if(direction == 2)	direction = 1;
					else if(direction == 3) direction = 4;
					else if(direction == 4) direction = 3;
					break;
				case 3:
					count++;
					length += steps;
					break;
			}

			switch(direction){
				case 1:
					preIndex = start.col;
					start = start.right;
					break;
				case 2:
					preIndex = start.row;
					start = start.down;
					break;
				case 3:
					preIndex = start.col;
					start = start.left;
					break;
				case 4:
					preIndex = start.row;
					start = start.up;
					break;
			}
		}
		
		Main.results[0][no] = count;
		Main.results[1][no] = length;
	}

	class Node{
	
		int row;
		int col;
		int type;	// 1 == '/' , 2 == '\' , 3 == 'O' , 4 == 'edge'

		Node left;
		Node right;
		Node up;
		Node down;

		Node(int row, int col, int type){
			this.row = row;
			this.col = col;
			this.type = type;
		}

		void insert(){

			Node rowL = Main.Ls[this.row];
		//	rowR = Main.Rs[this.row];
			Node colU = Main.Us[this.col];
		//	colD = Main.Ds[this.col];

			//
			while(rowL.right.col < this.col){
				rowL = rowL.right;
			}

			while(colU.down.row < this.row){
				colU = colU.down;
			}
			
			//
			this.right = rowL.right;
			rowL.right = this;
			this.left = rowL;
			this.right.left = this;

			//
			this.down = colU.down;
			colU.down = this;
			this.up = colU;
			this.down.up = this;
			
		}

	}
}
