import java.util.*;
import java.io.*;



class Main{

	static int N;
	static int S;
	static int D;
	static int length = 0;
	static Point[] point;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		point = new Point[N+1];
		
		for(int i = 0; i<N-1; i++){
			st = new StringTokenizer(bf.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(point[a] == null){
				point[a] = new Point(a);
			}
			if(point[b] == null){
				point[b] = new Point(b);
			}
			point[a].child.add(point[b]);
			point[b].child.add(point[a]);
		}

		// END OF INIt

		point[S].visited = 1;
		dfs(S);

		System.out.println(length * 2);

	}

	static int dfs(int index){

		int count = 0;

		Point tempPoint = point[index];
		for(Point next : tempPoint.child){
			if(next.visited == 0){
				next.visited = 1;
				int ret = dfs(next.index);
				if(count < ret + 1){
					count = (ret + 1);
				}
			}
		}
		if(D <= count && index != S){
			length++;
		}
		return count;
	}
}

class Point{

	int index;
	List<Point> child = new LinkedList<>();
	int visited = 0;

	Point(int i){
		this.index = i;
	}
}
