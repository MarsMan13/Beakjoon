import java.util.*;
import java.io.*;

class Main{
	
	static int N, M;
	static int[][] bowlMap;			// The much of stored water at i, j
	static int[][] cloudMap;		// The cloud-exist flag at i, j
	static int[][] cloudRemovedMap;	// The cloud removed flag at i, j
	static int[][] rainedMap;		// The check if rained at i, j currently
	static Order[] orders;			// Array of Order.
	
	static int[] diagonalI = new int[]{-1, -1, 1, 1};
	static int[] diagonalJ = new int[]{-1, 1, -1, 1};

	static int[] ii = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
	static int[] jj = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bowlMap = new int[N+1][N+1];
		cloudMap = new int[N+1][N+1];
		cloudRemovedMap = new int[N+1][N+1];
		rainedMap = new int[N+1][N+1];
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++){
				bowlMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		orders = new Order[M];
		for(int i = 0; i<M; i++){
			st = new StringTokenizer(bf.readLine());
			int d_ = Integer.parseInt(st.nextToken());
			int s_ = Integer.parseInt(st.nextToken());
			orders[i] = new Order(d_, s_);
		}
		// END OF INIT
		cloudMap[N][1] = cloudMap[N][2] = cloudMap[N-1][1] = cloudMap[N-1][2] = 1;
		for(int i = 0; i<M; i++){
			Order curOrder = orders[i];
			moveCloudByOrder(curOrder);
			doRain();
			duplicateWater();
			makeCloud();
		}
		System.out.println(sumBowl());
		
	}

	static void showMap(int[][] map){
		System.out.println("==================================");
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=N; j++){
				System.out.printf("%2d ", map[i][j]);
			}
			System.out.println();
		}
	}

	static int sumBowl(){
		int sum = 0;
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=N; j++){
				sum += bowlMap[i][j];
			}
		}
		return sum;
	}

	static void makeCloud(){
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=N; j++){
				if(bowlMap[i][j] >= 2 && cloudRemovedMap[i][j] == 0){
					cloudMap[i][j] = 1;
					bowlMap[i][j] -= 2;
				}
			}
		}
	}

	static void duplicateWater(){
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=N; j++){
				if(rainedMap[i][j] == 1){
					int countDiag = 0;
					for(int k = 0; k<4; k++){
						int diagI = i + diagonalI[k];
						int diagJ = j + diagonalJ[k];
						if(1<=diagI && diagI <=N && 1<= diagJ && diagJ <= N){
							if(bowlMap[diagI][diagJ] > 0){
								countDiag++;
							}
						}
					}
					//
					bowlMap[i][j] += countDiag;
				}
			}
		}
	}

	static void doRain()
	{
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=N; j++){
				rainedMap[i][j] = 0;
				cloudRemovedMap[i][j] = 0;
				if(cloudMap[i][j] == 1){
					bowlMap[i][j]++;
					rainedMap[i][j] = 1;
					cloudMap[i][j] = 0;
					cloudRemovedMap[i][j] = 1;
				}
			}
		}
	}

	static void moveCloudByOrder(Order order){
		int[][] newCloudMap = new int[N+1][N+1];
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=N; j++){
				if(cloudMap[i][j] == 1){
					int directI = ii[order.d-1];
					int directJ = jj[order.d-1];
					int stepI = directI * order.s;
					int stepJ = directJ * order.s;
					int newI = directI >= 0 ? calcPlusDirection(i, stepI) : calcMinusDirection(i, stepI);
					int newJ = directJ >= 0 ? calcPlusDirection(j, stepJ) : calcMinusDirection(j, stepJ);
					newCloudMap[newI][newJ] = cloudMap[i][j];
				}
			}
		}
		cloudMap = newCloudMap;
	}

	static int calcPlusDirection(int index, int s){
		return (index + s - 1) % N + 1;
	}

	static int calcMinusDirection(int index, int s){
		return (N + index + s%N - 1) % N + 1;
	}
}

class Order{
	int d, s;
	Order(int d, int s){
		this.d = d;
		this.s = s;
	}
}