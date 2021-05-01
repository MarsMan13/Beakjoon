import java.util.*;
import java.io.*;



class Main{
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		List<Point> list = new ArrayList<>();
		for(int i = 0; i<N; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(x, y));	
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(Point p : list){
			sb.append(p.x);
			sb.append(" ");
			sb.append(p.y);
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}

class Point implements Comparable<Point>{
	
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point p){
		if(this.x == p.x)
			return this.y - p.y;
		return this.x - p.x;
	}
}