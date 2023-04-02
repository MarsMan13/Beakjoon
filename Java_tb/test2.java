import java.util.*;
import java.io.*;
import java.math.*;

class Test {
	static int[][] possibleAttack = {{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,9,3},{1,3,9}};
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[3];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();;
		}
		int[][][] dp = new int[arr[0]+1][arr[1]+1][arr[2]+1];
		dp[arr[0]][arr[1]][arr[2]] = 0;
		BFS(new int[]{arr[0],arr[1],arr[2]}, dp);
		System.out.println(dp[0][0][0]);
		
	}
	
	public static void BFS(int[] start, int[][][] dp) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(start);
		while(!q.isEmpty()) {
				int[] now = q.poll();
				if(now[0] == 0 && now[1] == 0 && now[2] == 0) return ;
				for (int d = 0; d < 6; d++) {
					int[] attack = possibleAttack[d];
					int a = (now[0] - attack[0]>0)?now[0] - attack[0]:0;
					int b = (now[1] - attack[1]>0)?now[1] - attack[1]:0;
					int c = (now[2] - attack[2]>0)?now[2] - attack[2]:0;
					if(dp[a][b][c] ==0) {
						q.add(new int[] {a,b,c});
						dp[a][b][c] = dp[now[0]][now[1]][now[2]] +1;
					}
				}

		}
	}
}