import java.util.*;
import java.io.*;


class Main{

	static int[] arrow = null;
	static int[] visited = null;
	static int[] results = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 0; t<T; t++){
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			arrow = new int[n+1];
			visited = new int[n+1];
			results = new int[n+1];
			st = new StringTokenizer(bf.readLine());
			for(int i = 1; i<=n; i++)
				arrow[i] = Integer.parseInt(st.nextToken());
			//
	
			int bit = 1;
			for(int i = 1; i<=n; i++){
				if(visited[i] == 0){
					dfs(i, bit++);
				}
			}
			int ret = 0;
			for(int i = 1; i<=n; i++){
				if(results[i] == 0){
					ret++;
				}
			}
			System.out.println(ret);
		}
	}
	
	public static int dfs(int index, int bit){
	
		visited[index] = bit;
		if(visited[arrow[index]] != 0){
			if(visited[arrow[index]] == bit){
				return results[index] = arrow[index];
			}
			return results[index] = 0;
		}
		int ret = dfs(arrow[index], bit);
		if(index == ret){
			results[index] = ret;
			return 0;
		}
		return results[index] = ret;
	}
}





