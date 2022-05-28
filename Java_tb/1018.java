import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static char[][] board = null;
	static char[] type = {'W', 'B'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N+2][M+2];
		
		for(int i = 1; i<=N; i++){
			String line = bf.readLine();
			for(int j = 1; j<=M; j++){
				board[i][j] = line.charAt(j-1);	
			}
		}
		// END OF INIT
	
		int maxCount = -1;
		for(int head_i = 1; head_i <= N - 7; head_i++){
			for(int head_j = 1; head_j <= M - 7; head_j++){
				for(int t = 0; t<2; t++){
					int count = 0;
					for(int i = 0; i<8; i++){
						for(int j = 0; j<8; j++){
							if(board[head_i + i][head_j + j] != type[(i + j + t)%2]){
								count++;
							}
						}
					}
					if(maxCount == -1 || count < maxCount)
						maxCount = count;
				}
			}
		}
		
		System.out.println(maxCount);
		
		
	}
}