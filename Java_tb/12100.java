import java.util.*;


class Main{

	static int n;
	static int[][] map;
	static int[][] backupMap;
	static int score = -1;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
		backupMap = new int[n][n];

		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				backupMap[i][j] = sc.nextInt();
			}
		}

		// END OF INIT

		for(int a = 0; a<4; a++){	// try 1
			for(int b = 0; b<4; b++){	// try 2
				for(int c = 0; c<4; c++){	// try 3
					for(int d = 0; d<4; d++){	// try 4
						for(int e = 0; e<4; e++){	// try 5
							initMap();
							moveMap(a, 0);
							moveMap(b, 0);
							moveMap(c, 0);
							moveMap(d, 0);
							moveMap(e, 1);
						}
					}
				}
			}
		}
		System.out.println(score);
	}

	static void initMap(){

		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				map[i][j] = backupMap[i][j];
			}
		}
	}

	// --> 	: 0
	// 		: 1
	// <--	: 2
	// 	^	: 3
	static void moveMap(int direction, int option){
	
		if(direction == 0){

			for(int i = 0; i<n; i++){
			
				int pre = n-1;
				int point = n-2;
				while(0 <= point){
					if(map[i][point] != 0){
						if(map[i][point] == map[i][pre]){
							map[i][pre] *= 2;
							map[i][point] = 0;
						}
						pre = point;
					}
					point--;
				}

				// END OF STEP1

				int place = n-1;
				for(int j = n-1; 0<=j; j--){
					if(map[i][j] != 0){
						int temp = map[i][j];
						map[i][j] = 0;
						map[i][place--] = temp;
					}
				}
			}
		}
		else if(direction == 1){
			
			for(int i = 0; i<n; i++){
			
				int pre = n-1;
				int point = n-2;
				while(0 <= point){
					if(map[point][i] != 0){
						if(map[point][i] == map[pre][i]){
							map[pre][i] *= 2;
							map[point][i] = 0;
						}
						pre = point;
					}
					point--;
				}

				// END OF STEP1

				int place = n-1;
				for(int j = n-1; 0<=j; j--){
					if(map[j][i] != 0){
						int temp = map[j][i];
						map[j][i] = 0;
						map[place--][i] = temp;
					}
				}
			}

		}
		else if(direction == 2){
			
			for(int i = 0; i<n; i++){
			
				int pre = 0;
				int point = 1;
				while(point < n){
					if(map[i][point] != 0){
						if(map[i][point] == map[i][pre]){
							map[i][pre] *= 2;
							map[i][point] = 0;
						}
						pre = point;
					}
					point++;
				}

				// END OF STEP1

				int place = 0;
				for(int j = 0; j<n; j++){
					if(map[i][j] != 0){
						int temp = map[i][j];
						map[i][j] = 0;
						map[i][place++] = temp;
					}
				}
			}

		}
		else if(direction == 3){
			
			for(int i = 0; i<n; i++){
			
				int pre = 0;
				int point = 1;
				while(point<n){
					if(map[point][i] != 0){
						if(map[point][i] == map[pre][i]){
							map[pre][i] *= 2;
							map[point][i] = 0;
						}
						pre = point;
					}
					point++;
				}

				// END OF STEP1

				int place = 0;
				for(int j = 0; j<n; j++){
					if(map[j][i] != 0){
						int temp = map[j][i];
						map[j][i] = 0;
						map[place++][i] = temp;
					}
				}
			}

		}

		if(option == 1){
			int max = map[0][0];
			for(int i = 0; i<n; i++){
				for(int j = 0; j<n; j++){
					if(max < map[i][j])
						max = map[i][j];
				}
			}

			if(score < max)
				score = max;
		}
	}

	static void printMap(){
		System.out.println("=== printMap ====");
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
