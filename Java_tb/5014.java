import java.util.*;
import java.io.*;


class Main{

    static int[] visited = null;
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        visited = new int[F+1];
        visited[S] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(S, 0));
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            if(cur.i == G){
                System.out.println(cur.j);
                return;
            }
            int up = cur.i + U;
            int down = cur.i - D;
            if(up <= F && visited[up] == 0){
                visited[up] = 1;
                queue.offer(new Pair(up, cur.j+1));
            }
            if(1 <= down && visited[down] == 0){
                visited[down] = 1;
                queue.offer(new Pair(down, cur.j+1));
            }
        }
        System.out.println("use the stairs");
	}
}

class Pair{
    int i, j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}