import java.util.*;
import java.io.*;


class Main{
	
	static int N, M, K;
	static List<Sticker> sticker = new ArrayList<>();
	static int[][] map = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		map = new int[N+2][M+2];
		for(int i = 0; i<N+2; i++){
			map[i][0] = map[i][M+1] = -1;
		}	
		for(int i = 0; i<M+2; i++){
			map[0][i] = map[N+1][i] = -1;
		}
		
		for(int s = 0; s<K; s++){
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			Sticker newSticker = new Sticker(r, c);
			for(int i = 0; i<r; i++){
				st = new StringTokenizer(bf.readLine());
				for(int j = 0; j<c; j++){
					(newSticker.figure)[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sticker.add(newSticker);
		}
	
		
		// END OF INIT
		
		for(int s = 0; s<K; s++){
			Sticker currentSticker = sticker.get(s);
			int flag = 0;	// 1 --> success 
			loop_1: for(int rot = 0; rot<4; rot++){
				for(int head_i = 1; head_i <= N - currentSticker.r + 1; head_i++){
					for(int head_j = 1; head_j <= M - currentSticker.c + 1; head_j++){
						flag = 0;
						for(int i = 0; i<currentSticker.r; i++){
							for(int j = 0; j<currentSticker.c; j++){
								if(map[i+head_i][j+head_j] != 0 && currentSticker.figure[i][j] != 0){
									flag = 1;
								}
							}
						}	
						if(flag == 0){
							currentSticker.printSticker();
							for(int i = 0; i<currentSticker.r; i++){
								for(int j = 0; j<currentSticker.c; j++){
									map[i+head_i][j+head_j] = currentSticker.figure[i][j];
								}
							}
							break loop_1;
						}
					}
				}
				currentSticker.rotate();
			}
		}
		
		int result = 0;
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=M; j++){
				System.out.print(map[i][j]+" ");
				if(map[i][j] == 1)
					result++;
			}
			System.out.println();
		}
		System.out.println(result);
		
	}
}

class Sticker{
	int r, c;
	int[][] figure = null;
	
	Sticker(int r, int c){
		this.r = r;
		this.c = c;
		figure = new int[r][c];
	}
	
	public void rotate(){
		
		int[][] figure2 = new int[c][r];
		
		for(int i = 0; i<r; i++){
			for(int j = 0; j<c; j++){
				figure2[j][r-i-1] = figure[i][j];
			}
		}
		int temp = r;
		r = c;
		c = temp;
		figure = figure2;
	}
	
	public void printSticker(){
		for(int i = 0; i<r; i++){
			for(int j = 0; j<c; j++){
				System.out.print(figure[i][j]);
			}
			System.out.println();
		}
	}
	
}