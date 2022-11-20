import java.util.*;
import java.io.*;

class Main{
	
	static int N;
	static List<Class> classes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			classes.add(
				new Class(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
				)
			);
		}
		Collections.sort(classes);
		TreeMap<Integer, Integer> starts = new TreeMap<>();
		int max = 0;
		int currentClassNumber = 0;
		for(Class c : classes){
			while(!starts.isEmpty() && c.end <= starts.lastKey()){
				currentClassNumber -= starts.pollLastEntry().getValue();	
			}
			if(starts.get(c.start) == null){
				starts.put(c.start, 1);
			}
			else{
				starts.put(c.start, starts.get(c.start)+1);
			}
			currentClassNumber+=1;
			if(max < currentClassNumber)
				max = currentClassNumber;
		}
		System.out.println(max);
	}
}

class Class implements Comparable<Class>{
	int index;
	int start;
	int end;

	Class(int index, int start, int end){
		this.index = index;
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Class o){
		if(this.end == o.end){
			if(this.start == o.start)
				return this.index - o.index;
			return o.start - this.start;
		}
		return o.end - this.end;
	}
}