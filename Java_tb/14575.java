import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		List<Info> infos = new ArrayList<>();
		PriorityQueue<Info> pq = null;
		int sumL = 0;
		int sumR = 0;
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			Info temp = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			sumL += temp.L;
			sumR += temp.R;
			infos.add(temp);
		}
		if(!(sumL <= T && T <= sumR)){
			System.out.println(-1);
			return;
		}
		for(Info i : infos){
			i.input = i.L;
			T -= i.input;
		}
		pq = new PriorityQueue<>(infos);
		while(0 < T){
			Info tempInfo = pq.poll();
			tempInfo.input += 1;
			T--;
			pq.offer(tempInfo);
		}

		int maxInput = 0;
		for(Iterator<Info> itr = pq.iterator(); itr.hasNext(); ){
			maxInput = Math.max(maxInput, itr.next().input);
		}
		System.out.println(maxInput);
	}
}

class Info implements Comparable<Info>{
	int L, R;
	int input;
	Info(int L, int R){
		this.L = L;
		this.R = R;
	}

	@Override
	public int compareTo(Info o){
		return this.input - o.input;
	}
}