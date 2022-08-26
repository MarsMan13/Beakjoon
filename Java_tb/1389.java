import java.util.*;
import java.io.*;

class Main{

	static final int INF = 1000;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] relationship = new int[N+1][N+1];
		for(int i = 0; i<=N; i++)
			for(int j = 0; j<=N; j++)
				relationship[i][j] = INF;
		// END OF INIT
		for(int i = 0; i<M; i++){
			st = new StringTokenizer(bf.readLine());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());

			relationship[f1][f2] = 1;
			relationship[f2][f1] = 1;
		}

		for(int k = 1; k<=N; k++){
			for(int i = 1; i<=N; i++){
				for(int j = 1; j<=N; j++){
					if(i == j){
						relationship[i][j] = 0;
						continue;
					}
					relationship[i][j] = Math.min(relationship[i][j], relationship[i][k] + relationship[k][j]);
				}
			}
		}
		int minIndex = -1;
		int minValue = -1;
		for(int i = 1; i<=N; i++){
			int lineSum = 0;
			for(int j = 1; j<=N; j++)	lineSum += relationship[i][j];
			if(minValue == -1 || lineSum < minValue){
				minIndex = i;
				minValue = lineSum;
			}
		}
		System.out.println(minIndex);
	}
}