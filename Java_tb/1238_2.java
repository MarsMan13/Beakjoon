import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

class Main{
	public static final int INF = 1000*100+1;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String line[] = in.readLine().split(" ");	
        int i, from, to, w, maxDist = 0;
		int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]), x = Integer.parseInt(line[2])-1;
		
		int [][]map = new int[n][n], revMap = new int[n][n];
		int []dist = new int[n], revDist = new int[n];
		
		init(map, revMap, dist, revDist, n); //INF로 초기화
		
		for(i=0;i<m;i++){
			line = in.readLine().split(" ");
			from = Integer.parseInt(line[0])-1; 
			to = Integer.parseInt(line[1])-1; 
			w = Integer.parseInt(line[2]);
			map[from][to] = revMap[to][from] = w;
		}
		
		dijkstra(x, map, dist, n); //목적지에서 각 마을로 가는 최단 거리 탐색
		dijkstra(x, revMap, revDist, n); //각 마을에서 목적지로 돌아오는 최단 거리 탐색
		
		for(i=0;i<n;i++) //최대값 탐색
			if(maxDist<dist[i]+revDist[i]) 
				maxDist = dist[i]+revDist[i];
		
		out.write(String.valueOf(maxDist));
		out.close();
		in.close();
	}
	
	private static void dijkstra(int start, int map[][], int dist[], int n){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(start); 
		map[start][start] = 0; 
		dist[start] = 0;
		
		while(!pq.isEmpty()){
			int x = pq.poll();
			for(int i=0;i<n;i++)
				if(dist[i]>map[x][i]+dist[x]){
					dist[i] = map[x][i]+dist[x];
					pq.offer(i);
				}
		}
	}
	
	private static void init(int map[][], int revMap[][], int dist[], int revDist[], int n){
		for(int i=0;i<n;i++){
			dist[i] = revDist[i] = INF;
			for(int j=0;j<n;j++) 
				map[i][j] = revMap[i][j] = INF;
		}
	}
}
