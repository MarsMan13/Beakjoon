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
	
		// Rotating callipers algorithms
		List<Pair> main = new ArrayList<>();
		while(!(stack.isEmpty()))
			main.add(stack.pop());
		Collections.reverse(main);
		int pl, pr;	// One pair : p1, p2 / The other pair : p3, p4
		pl = pr = 0;
		for(int i = 0; i<main.size(); i++){
			if(main.get(i).i < main.get(pl).i)	pl = i;
			if(main.get(i).i > main.get(pr).i)	pr = i;
		}
		int nn = main.size();
		Pair callipers = new Pair(0, 1);
		// END OF GET STARTING POINT
		
		double result = Pair.distance(main.get(pl), main.get(pr));
		for(int i = 0; i<nn; i++){
			int dx1 = main.get((pl+1)%nn).i - main.get(pl).i;
			int dy1 = main.get((pl+1)%nn).j - main.get(pl).j;
			
			int dx2 = main.get((pr+1)%nn).i - main.get(pr).i;
			int dy2 = main.get((pr+1)%nn).j - main.get(pr).j;
			
			//
			
			long ccwValue = Pair.CCW2(new Pair(0, 0), new Pair(dx1, dy1), new Pair(dx2, dy2));
			if(ccwValue > 0L)
				pr = (pr+1)%nn;
			else
				pl = (pl+1)%nn;
			
			result = Math.max(result, Pair.distance(main.get(pl), main.get(pr)));
		}
		System.out.println(result);
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
	
	public static double distance(Pair p1, Pair p2){
		int xd2 = (int)Math.pow((p1.i - p2.i), 2);
		int yd2 = (int)Math.pow((p1.j - p2.j), 2);
		return Math.sqrt(xd2+yd2);
	}
	
	public double distanceFromZero(){
		return distance(this, new Pair(0, 0));
	}
	
	static double angle(Pair u1, Pair u2){
		double ret = Math.acos(((u1.i * u2.i) + (u1.j * u2.j))/(u1.distanceFromZero() * u2.distanceFromZero()));
		if(ret == Math.PI)
			return 0.0;
		return ret;
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


