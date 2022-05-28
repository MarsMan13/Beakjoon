
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
		
		Pair cur = list.remove(0);
		Collections.sort(list, new PairComparator(cur));
		Stack<Pair> stack = new Stack<>();
		stack.push(cur);
		for(Pair p : list){
			if(2 <= stack.size()){
				while(2 <= stack.size()){
					Pair firstOutLastIn = stack.pop();
					Pair lastOutFirstIn = stack.pop();

					long ret = Pair.CCW(lastOutFirstIn, firstOutLastIn, p);

					stack.push(lastOutFirstIn);
					stack.push(firstOutLastIn);

					if(0 < ret){
						break;
					}
					else{
						stack.pop();
					}
				}
				stack.push(p);
			}
			else
				stack.push(p);
		}
	
		List<Pair> main = new ArrayList<>(stack);
		double max = 0;
		for(int i = 0; i<main.size(); i++){
			Pair p1 = main.get(i);
			for(int j = i+1; j<main.size(); j++){
				Pair p2 = main.get(j);	
				int xd = (int)Math.pow((p2.i - p1.i), 2);
				int yd = (int)Math.pow((p2.j - p1.j), 2);
				double ret = Math.sqrt(xd + yd);
				if(ret > max)
					max = ret;
			}
		}
		System.out.println(max);
	}
}


class Pair implements Comparable<Pair>{
	
	static long CCW(Pair p1, Pair p2, Pair p3){
		return 1L * (p2.i - p1.i)*(p3.j - p2.j) - 1L*(p3.i - p2.i)*(p2.j - p1.j);
	}
	
	static long CCW2(Pair p1, Pair p2, Pair p3){
		return 1L * (p2.i - p1.i)*(p3.j - p1.j) - 1L*(p3.i - p1.i)*(p2.j - p1.j);
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
		return "i: "+i+", j: "+j;
	}
}

class PairComparator implements Comparator<Pair>{
	
	Pair root = null;
	
	PairComparator(Pair root){
		this.root = root;
	}
	
	@Override
	public int compare(Pair p1, Pair p2){
		long ret = Pair.CCW2(root, p1, p2);
		if(0 < ret)
			return -1;
		else if(ret < 0)
			return 1;
		
		long distanceP1 =  1L * (p1.i - root.i)*(p1.i - root.i) + 1L*(p1.j - root.j) * (p1.j - root.j);
		long distanceP2 = 1L * (p2.i - root.i)*(p2.i - root.i) + 1L*(p2.j - root.j) * (p2.j - root.j);
	
		if(distanceP1 < distanceP2)
			return -1;
		else if(distanceP1 > distanceP2)
			return 1;
		return 0;
	}
}



