import java.util.*;
import java.io.*;


class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int A = Integer.parseInt(st.nextToken());	int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		List<Order> blueOrders = new ArrayList<>();
		List<Order> redOrders = new ArrayList<>();
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			int t = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			int m = Integer.parseInt(st.nextToken());
			if(c.equals("B")){
				blueOrders.add(new Order(t, c, m));
			}
			else{
				redOrders.add(new Order(t, c, m));
			}
		}
		long finishTime = 0L;
		TreeMap<Long, ArrayList<Integer>> results = new TreeMap<>();
		for(Order o : blueOrders){
			long startTime = (finishTime < 0L + o.t) ? 0L + o.t : finishTime;
			for(int m = 0; m < o.m; m++){
				ArrayList<Integer> temp = results.get(startTime + m * A);
				if(temp == null)	temp = new ArrayList<>();
				temp.add(-1);
				results.put(startTime + m * A, temp);
			}
			finishTime = startTime + o.m * A;
		}
		finishTime = 0L;
		for(Order o : redOrders){
			long startTime = (finishTime < 0L + o.t) ? 0L + o.t : finishTime;
			for(int m = 0; m < o.m; m++){
				ArrayList<Integer> temp = results.get(startTime + m * B);
				if(temp == null)	temp = new ArrayList<>();
				temp.add(1);
				results.put(startTime + m * B, temp);
			}
			finishTime = startTime + o.m * B;
		}
		int counter = 1;
		List<Integer> blueResults = new ArrayList<>();
		List<Integer> redResults = new ArrayList<>();
		for(Map.Entry<Long, ArrayList<Integer>> entry : results.entrySet()){
			ArrayList<Integer> temp = entry.getValue();
			Collections.sort(temp);
			for(int v : temp){
				if(v == -1)	blueResults.add(counter++);
				else		redResults.add(counter++);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(blueResults.size());	sb.append("\n");
		for(int v : blueResults){
			sb.append(v);	sb.append(" ");
		}	sb.append("\n");
		sb.append(redResults.size());	sb.append("\n");
		for(int v : redResults){
			sb.append(v);	sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}

class Order{
	int t;
	String c;
	int m;
	Order(int t, String c, int m){
		this.t = t;
		this.c = c;
		this.m = m;
	}
}