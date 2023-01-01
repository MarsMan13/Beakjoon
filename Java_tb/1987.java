import java.util.*;
import java.io.*;

class Main{
	
	static int R, C;				// 보드의 크기
	static char[][] map = null;		// 보드의 저장하는 2차원 배열
	static int[] visited = null; 	// 지금까지 지나온 알파벳을 저장하는 크기 26인 배열
	static int answer = 0;			// 정답(최대 이동 길이)를 저장
	static int[] ii = {1, -1, 0, 0};// 상하 이동 사용
	static int[] jj = {0, 0, 1, -1};// 좌우 이동에 사용
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new int[27];
		for(int i = 0; i<R; i++){
			String aline = bf.readLine();
			for(int j = 0; j<C; j++){
				map[i][j] = aline.charAt(j);
			}
		}
		// END OF INIT
		dfs(0, 0, 1);	
		System.out.println(answer);	
	}

	public static void dfs(int i, int j, int count){
		// System.out.println(i+" "+j+" "+map[i][j]);
		visited[map[i][j] - 'A'] = 1;	// 현재 위치의 알파벳을 지났다고 표시
		answer = answer < count ? count : answer;	// 답 갱신
		for(int k = 0; k<4; k++){	// 상하좌우에 대해
			int newI = i + ii[k];
			int newJ = j + jj[k];
			// 만약, 이제 가려는 곳이 보드 내부이며, 그곳의 알파벳을 아직 지나오지 않았다면 Go!
			if(0<=newI && newI < R && 0<=newJ && newJ < C && visited[map[newI][newJ] - 'A'] == 0){
				dfs(newI, newJ, count+1);
			}
		}
		visited[map[i][j] - 'A'] = 0;	// BackTracking!! 현재 위치의 알파벳 풀어주기!
	}
}