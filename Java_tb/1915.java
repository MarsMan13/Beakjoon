import java.util.*;
import java.io.*;


class Main{
	
	static int n, m;
	static int[][] map = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());	m = Integer.parseInt(st.nextToken());
		
		map = new int[n+2][m+2];
		for(int i = 0; i<=n+1; i++)	map[i][0] = map[i][m+1] = 0;
		for(int j = 0; j<=m+1; j++)	map[0][j] = map[n+1][j] = 0;
		
		for(int i = 1; i<=n; i++){
			String line = bf.readLine();
			for(int j = 1; j<=m; j++){
				map[i][j] = line.charAt(j-1)-'0';
			}
		}
		//
		int[][] dp = new int[n+2][m+2];
		
		for(int j = 1; j<=m; j++){
			int temp = 0;
			for(int i = n; 1<=i; i--){
				if(map[i][j] == 0)
					temp = 0;
				temp += map[i][j];
				dp[i][j] = temp;
			}
		}
		//
		
		int maxSize = 0;
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=m; j++){
				int counter = 0;
				int min = 1000000;
				for(int k = j; k<=m; k++){
					
					if(map[i][k] == 0){
						break;
					}
					//
					counter++;
					min = Math.min(min, dp[i][k]);
					int tempSize = Math.min(counter, min);
					tempSize *= tempSize;
					if(maxSize < tempSize)
						maxSize = tempSize;
					
				}
			}
		}
		
		System.out.println(maxSize);
	}
}

