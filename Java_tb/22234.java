import java.util.*;
import java.io.*;

class Main{
	static int N, T, W;	
	static int M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Queue<Customer> customerQueue = new LinkedList<>();
		List<Customer> commingList = new LinkedList<>();
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			int _p = Integer.parseInt(st.nextToken());
			int _t = Integer.parseInt(st.nextToken());
			customerQueue.offer(new Customer(_p, _t, 0));
		}
		M = Integer.parseInt(bf.readLine());
		for(int i = 0; i<M; i++){
			st = new StringTokenizer(bf.readLine());
			int _p = Integer.parseInt(st.nextToken());
			int _t = Integer.parseInt(st.nextToken());
			int _c = Integer.parseInt(st.nextToken());
			commingList.add(new Customer(_p, _t, _c));
		}
		Collections.sort(commingList);
		Queue<Customer> commingQueue = new LinkedList<>(commingList);
		// END OF INIT
		StringBuilder output = new StringBuilder();
		int t = 0;
		while(true){
			Customer curCustomer = customerQueue.poll();
			int operatingTime = curCustomer.t > T ? T : curCustomer.t;
			curCustomer.t -= operatingTime;
			for(int tt = 0; tt<operatingTime && t < W; tt++){
				output.append(curCustomer.p);
				output.append("\n");
				t++;
			}
			if(t >= W)	break;
			//
			while(!commingQueue.isEmpty() && commingQueue.peek().c <= t){
				Customer newCustomer = commingQueue.poll();
				customerQueue.offer(newCustomer);
			}
			if(curCustomer.t > 0){
				customerQueue.offer(curCustomer);
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(output.toString());
		bw.close();
	}
}

class Customer implements Comparable<Customer>{

	int p, t, c;
	Customer(int p, int t, int c){
		this.p = p;
		this.t = t;
		this.c = c;
	}

	@Override
	public int compareTo(Customer o){
		return this.c - o.c;
	}
}