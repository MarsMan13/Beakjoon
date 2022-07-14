import java.util.*;
import java.io.*;

class Main{

	static int N = 0;
	static Task[] tasks = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		tasks = new Task[N];
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			int time = Integer.parseInt(st.nextToken());
			int preCount = Integer.parseInt(st.nextToken());
			tasks[i] = new Task(i, time);
			for(int j = 0; j<preCount; j++){
				int preTask = Integer.parseInt(st.nextToken()) - 1;
				tasks[i].preTasks.add(preTask);
			}
		}
		// END OF INIT
		int max = 0;
		for(int i = 0; i<N; i++){
			if(tasks[i].dist == -1)
				dfs(i);
			max = Math.max(max, tasks[i].dist);
		}
		System.out.println(max);
	}

	public static int dfs(int index){
		Task curTask = tasks[index];
		int dist = 0;
		for(int i : curTask.preTasks){
			if(tasks[i].dist == -1)
				dfs(i);
			dist = Math.max(dist, tasks[i].dist);	
		}
		curTask.dist = dist + curTask.time;
		return dist;
	}
}

class Task{

	int index;
	int time;
	int dist = -1;
	List<Integer> preTasks = new ArrayList<>();

	Task(int index, int time){
		this.index = index;
		this.time = time;
	}
}