import java.util.*;
import java.io.*;


class Main{

	static Part[][][] mat;
	static Part[][] area = new Part[5][5];
	static int score = -987654321;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
	
		mat = new Part[n][4][4];
		
		for(int i = 0; i<5; i++){
			for(int j = 0; j<5; j++){
				area[i][j] = new Part();
			}
		}

		StringTokenizer st;
		for(int i = 0; i<n; i++){
			// About quaility
			for(int j = 0; j<4; j++){
				st = new StringTokenizer(bf.readLine());

				int k = 0;
				while(st.hasMoreTokens()){
					int temp = Integer.parseInt(st.nextToken());
					mat[i][j][k] = new Part();
					mat[i][j][k].qual = temp;
					k++;
				}
			}

			// About color
			for(int j = 0; j<4; j++){
				st = new StringTokenizer(bf.readLine());

				int k = 0;
				while(st.hasMoreTokens()){
					String temp = st.nextToken();
					switch(temp){
						case "W":
							mat[i][j][k].color = 0;
							break;
						case "R":
							mat[i][j][k].color = 1;
							break;
						case "G":
							mat[i][j][k].color = 2;
							break;
						case "B":
							mat[i][j][k].color = 3;
							break;
						case "Y":
							mat[i][j][k].color = 4;
							break;
					}	
					k++;
				}
			}
		}
		// END OF INIT
		//
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				if(i == j)	continue;
				for(int k = 0; k<n; k++){
					if(i == j || j == k || i == k)	continue;
					insertMat(i, j, k);
				}
			}
		}

		System.out.println(score);
	}

	static void insertMat(int level1, int level2, int level3){

		for(int i = 0; i<4; i++){
			for(int ii = 0; ii<4; ii++){
				for(int j = 0; j<4; j++){
					for(int jj = 0; jj<4; jj++){
						for(int k = 0; k<4; k++){
							for(int kk = 0; kk<4; kk++){
								cleanArea();
								insertMat2(level1, i, ii);	
								insertMat2(level2, j, jj);	
								insertMat2(level3, k, kk);	
								checkResult();
							}
						}
					}
				}
			}
		}
	}

	static void insertMat2(int index, int position, int direction){

		int row = 0;
		int col = 0;

		switch(position){
			case 0:
				break;
			case 1:
				col = 1;
				break;
			case 2:
				row = 1;
				break;
			case 3:
				row = 1;
				col = 1;
				break;
		}	

		switch(direction){
			case 0:
				for(int i = 0; i<4; i++){
					for(int j = 0; j<4; j++){
						if(mat[index][i][j].color != 0)
							area[row+i][col+j].color = mat[index][i][j].color;
						area[row+i][col+j].qual += mat[index][i][j].qual;
						if(area[row+i][col+j].qual < 0)
							area[row+i][col+j].qual = 0;
						if(area[row+i][col+j].qual > 9)
							area[row+i][col+j].qual = 9;
					}
				}
				break;
			case 1:
				for(int i = 0; i<4; i++){
					for(int j = 0; j<4; j++){
						if(mat[index][j][3-i].color != 0)
							area[row+i][col+j].color = mat[index][j][3-i].color;
						area[row+i][col+j].qual += mat[index][j][3-i].qual;
						if(area[row+i][col+j].qual < 0)
							area[row+i][col+j].qual = 0;
						if(area[row+i][col+j].qual > 9)
							area[row+i][col+j].qual = 9;
					}
				}
				break;
			case 2:
				for(int i = 0; i<4; i++){
					for(int j = 0; j<4 ; j++){
						if(mat[index][3-i][3-j].color != 0)
							area[row+i][col+j].color = mat[index][3-i][3-j].color;
						area[row+i][col+j].qual += mat[index][3-i][3-j].qual;
						if(area[row+i][col+j].qual < 0)
							area[row+i][col+j].qual = 0;
						if(area[row+i][col+j].qual > 9)
							area[row+i][col+j].qual = 9;
					}
				}
				break;
			case 3:
				for(int i = 0; i<4; i++){
					for(int j = 0; j<4; j++){
						if(mat[index][3-j][i].color != 0)
							area[row+i][col+j].color = mat[index][3-j][i].color;
						area[row+i][col+j].qual += mat[index][3-j][i].qual;
						if(area[row+i][col+j].qual < 0)
							area[row+i][col+j].qual = 0;
						if(area[row+i][col+j].qual > 9)
							area[row+i][col+j].qual = 9;
					}
				}
				break;
		}	

	}

	static int checkResult(){
		int tempResult = 0;
		for(int i = 0; i<5; i++){
			for(int j = 0; j<5; j++){
				int colorTemp = area[i][j].color;
				switch(colorTemp){
					case 1:	// R
						tempResult += 7*area[i][j].qual;
						break;
					case 2:	// G
						tempResult += 3*area[i][j].qual;
						break;
					case 3:	// B
						tempResult += 5*area[i][j].qual;
						break;
					case 4:	// Y
						tempResult += 2*area[i][j].qual;
						break;
					default:	//W
						break;
				}
			}
		}
		if(tempResult > Main.score){
			Main.score = tempResult;
		}
		return tempResult;
	}

	static void cleanArea(){
		for(int i = 0; i<5; i++){
			for(int j = 0; j<5; j++){
				area[i][j].qual = 0;
				area[i][j].color = 0;
			}
		}	
	}
}

class Part{
	int qual;
	int color;	// R 1, G 2, B 3, Y 4, W 0
}
