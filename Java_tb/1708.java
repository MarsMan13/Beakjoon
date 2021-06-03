import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static List<Pair> list = new ArrayList<Pair>();
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		//
		Collections.sort(list);
		
		Pair cur = list.get(0);
		list.remove(0);
		Collections.sort(list, new PairComparator(cur));
		Stack<Pair> stack = new Stack<>();
		stack.push(cur);
		for(Pair p : list){
			if(2 <= stack.size()){
				Pair firstOutLastIn = stack.pop();
				Pair LastOutFirstIn = stack.pop();
		
				
				long ret = Pair.CCW(LastOutFirstIn, firstOutLastIn, p);
				
				stack.push(LastOutFirstIn);
				stack.push(firstOutLastIn);
				
				if(0 < ret)
					stack.push(p);
				else{
					stack.pop();
					stack.push(p);
				}
			}
			else
				stack.push(p);
		}
		
		System.out.println(stack.size());
	}
}


class Pair implements Comparable<Pair>{
	
	static long CCW(Pair p1, Pair p2, Pair p3){
		return 1L * (p2.i - p1.i)*(p3.j - p2.j) - (p3.i - p2.i)*(p2.j - p1.j);
	}
	
	int i, j;

	Pair(int i, int j){
		this.i = i;	this.j = j;
	}
	
	@Override
	public int compareTo(Pair p){
		if(this.i == p.i && this.j == p.j)
			return 0;
		if(this.j > p.j)
			return 1;
		if(this.j == p.j && this.i > p.i)
			return 1;
		return -1;
	}
	
	@Override
	public String toString(){
		return "i: "+this.i+", j: "+this.j;
	}
}

class PairComparator implements Comparator<Pair>{
	
	Pair root = null;
	
	PairComparator(Pair root){
		this.root = root;
	}
	
	@Override
	public int compare(Pair p1, Pair p2){
		long aboutP1 = 1L * (p2.i - root.i) * (p1.j - root.j);
		long aboutP2 = 1L * (p1.i - root.i) * (p2.j - root.j);
		if(0 <= aboutP1 && 0 <= aboutP2){
			long ret = aboutP1 - aboutP2;
			if(ret < 0)
				return -1;
			else if(0 < ret)
				return 1;
			else
				return 0;
		}
		else if(aboutP1 < 0 && aboutP2 < 0){
			long ret = aboutP2 - aboutP1;
			if(ret < 0)
				return -1;
			else if(0 < ret)
				return 1;
			else
				return 0;
		}
		else if(aboutP1 < 0 && 0 <= aboutP2){
			return 1;
		}
		else if( 0<= aboutP1 && aboutP2 < 0){
			return -1;
		}
		return 0;
	}
}