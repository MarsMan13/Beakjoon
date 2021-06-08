import java.util.*;
import java.io.*;
class Main{
	static int n, m;
	static int[][] map = null;
	static int[][] visited = null;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());	m = Integer.parseInt(st.nextToken());
		map = new int[m+2][n+2];
		visited = new int[m+2][n+2];
		for(int i = 0; i<m+2; i++)	map[i][0]=map[i][n+1]=32;
		for(int j = 0; j<n+2; j++)	map[0][j]=map[m+1][j]=32;
		for(int i = 1; i<=m; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=n; j++){
				int kan=Integer.parseInt(st.nextToken());
				for(int k = 0;k<minors.length; k++){
					if(kan-minors[k]>=0){
						map[i][j]=map[i][j]|(1<<(3-k));
						kan -= minors[k];
					}
				}
			}
		}
		List<Integer> results = new ArrayList<>();	results.add(0);
		int count = 1;
		int maxLength = 0;
		for(int i = 1; i<=m; i++){
			for(int j = 1; j<=n; j++){
				if(visited[i][j] == 0){
					visited[i][j] = count;
					int ret = dfs(i, j, count++);
					if(maxLength < ret)
						maxLength = ret;
					results.add(ret);
				}
			}
		}
		int afterMax = 0;
		for(int i = 1; i<=m; i++){
			for(int j = 1; j<=n; j++){
				for(int k = 0; k<4; k++){
					int dir = (map[i][j] >> k)%2;
					if(dir == 1){
						int new_i = i + ii[k];			int new_j = j + jj[k];
						if(map[new_i][new_j] >= 32)
							continue;
						if(visited[i][j] != visited[new_i][new_j]){
							int tempSum = results.get(visited[i][j])+results.get(visited[new_i][new_j]);
							if(afterMax < tempSum)
								afterMax = tempSum;
						}
					}
				}
			}
		}
		System.out.println((count-1)+"\n"+maxLength+"\n"+afterMax);
	}
	static int dfs(int i, int j, int flag){
		int ret = 1;
		for(int k = 0; k<4; k++){
			int dir = (map[i][j] >> k)%2;
			int new_i = i+ii[k];	int new_j = j+jj[k];
			if(dir == 0 && visited[new_i][new_j] == 0 && map[new_i][new_j] < 32){
				visited[new_i][new_j] = flag;
				ret += dfs(new_i, new_j, flag);
			}
		}
		return ret;
	}
	static int[] ii = new int[]{0, -1, 0, 1};
	static int[] jj = new int[]{-1, 0, 1, 0};
	static int[] minors = new int[]{8, 4, 2, 1};
}





