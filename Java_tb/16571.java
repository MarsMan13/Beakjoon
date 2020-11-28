import java.util.*;


class Main{

	static int[][] board = new int[5][5];

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int one = 0;
		int two = 0;
		for(int i = 1; i<=3; i++){
			for(int j = 1; j<=3; j++){
				int temp = sc.nextInt();
				if(temp == 1)	one++;
				else if(temp == 2)	two++;
				board[i][j] = sc.nextInt();
			}
		}
	
		// END OF INIT
		int result = -1;
		if(one <= two)
			result = dfs(1);
		else
			result = dfs(2);

		switch(result){
			case 0:
				System.out.println("D");
				break;
			case 1:
				System.out.println("W");
				break;
			case 2:
				System.out.println("L");
				break;
		}
			
	}

	static int dfs(int who){

		int after = -1;

		int zero = 0;
		for(int i = 1; i<=3; i++){
			for(int j = 1; j<=3; j++){
				if(board[i][j] != 0)	continue;

				board[i][j] = who;
				int temp = checkWin();
				switch(temp){
					case 0:
						return 0;
						break;
					case 1:
						if(who == 1){
							return 1;
						}
						else{
							continue;
						}
						break;
					case 2:
						if(who == 2){
							return 2;
						}
						else{
							continue;
						}
						break;
					case -1:
						if(who == 1){
							int next = dfs(2);
							if(next == 1){

							}
						}
						else if(who == 2){
							int next = dfs(1);
							if(next == 2){

							}
						}
						break;
				}

		}

	}

	static int checkWin(){
		//
		int pre = 0;
		int flag = 0;
		for(int i = 1; i<=3; i++){
			pre = board[i][1];
			flag = pre;
			for(int j = 1; j<=3; j++){
				if(pre != board[i][j])
					flag = 0;
			}
			if(flag != 0)
				return flag;
		}
		for(int j = 1; j<=3; j++){
			pre = board[1][j];
			flag = pre;
			for(int i = 1; i<=3; i++){
				if(pre != board[i][j])
					flag = 0;
			}
			if(flag != 0)
				return flag;
		}

	
		// Cross
		if(board[1][1] == board[2][2] && board[2][2] == board[3][3]){
			return board[1][1];
		}
		if(board[1][3] == board[2][2] && board[2][2] == board[3][1]){
			return board[1][3];
		}

		// Can we keep going
		for(int i = 1; i<=3; i++){
			for(int j = 1; j<=3; j++){
				if(board[i][j] == 0)
					return -1;
			}
		}

		return 0;
	}
}
