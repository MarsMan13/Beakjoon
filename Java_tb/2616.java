import java.util.*;
import java.io.*;

class Main{

	static int N = 0;
	static int maxCount = 0;
	static int[] input = null;
	static int[] subsum = null;
	static List<Range> range = new ArrayList<>();


	public static void main(String[] args) throws IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		input = new int[N];
		subsum = new int[N];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			input[i] = Integer.parseInt(st.nextToken());
		}
		maxCount = Integer.parseInt(bf.readLine());

		// END OF INIT
		
		int sum = 0;
		for(int i = 0; i<maxCount-1; i++){
			sum += input[i];
		}
		for(int i = 0; i<N-maxCount+1; i++){
			int to = i + maxCount - 1;
			sum+=input[to];
			range.add(new Range(i, to, sum));
			sum-=input[i];
		}

		// END OF INIT2
		
	}
}


class Range implements Comparable<Range>{

	int from, to;
	int value;

	Range(int from, int to, int value){
		this.from = from;
		this.to = to;
		this.value = value;
	}

	@Override
	public int compareTo(Range o){
		return this.value - o.value;
	}

	@Override
	public String toString(){
		return "from: "+from+" to: "+to+" , Sum is "+value;
	}
}
