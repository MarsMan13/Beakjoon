import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		List<Pair> inputs = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int maxD = 0;
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Pair temp = new Pair(d, w);
			maxD = Math.max(maxD, d);
			inputs.add(temp);
		}
		Collections.sort(inputs);
		// END OF INIT
		int[] days = new int[maxD+1];
		for(int i = 0; i<inputs.size(); i++){
			Pair target = inputs.get(i);
			for(int d = target.d; 0<d; d--){
				if(days[d] == 0){
					days[d] = target.w;
					break;
				}
			}
		}
		int result = 0;
		for(int i = 1; i<=maxD; i++)	result += days[i];
		System.out.println(result);	
	}
}

class Pair implements Comparable<Pair>{
	int d, w;
	Pair(int d, int w){
		this.d = d;
		this.w = w;
	}

	@Override
	public int compareTo(Pair o){
		if(this.w == o.w)
			return this.d - o.d;
		return o.w - this.w;
	}
}