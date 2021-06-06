import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static List<Pair> list = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t<T; t++){
			
			st = new StringTokenizer(bf.readLine());	
			N = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();
			for(int i = 0; i<N; i++){
				st = new StringTokenizer(bf.readLine());
				list.add(new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
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

						if(0L < ret){
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
			// END OF GET STARTING POINT
			
			int plMax = pl;	int prMax = pr;
			double result = Pair.distance(main.get(pl), main.get(pr));
			for(int i = 0; i<nn; i++){
				long dx1 = 0L + main.get((pl+1)%nn).i - main.get(pl).i;
				long dy1 = 0L + main.get((pl+1)%nn).j - main.get(pl).j;

				long dx2 = 0L + main.get((pr+1)%nn).i - main.get(pr).i;
				long dy2 = 0L + main.get((pr+1)%nn).j - main.get(pr).j;
				//
				long ccwValue = Pair.CCW2(new Pair(0L, 0L), new Pair(dx1, dy1), new Pair(dx2, dy2));
				if(ccwValue > 0L)
					pr = (pr+1)%nn;
				else
					pl = (pl+1)%nn;

				if(result < Pair.distance(main.get(pl), main.get(pr))){
					result = Math.max(result, Pair.distance(main.get(pl), main.get(pr)));
					plMax = pl;	prMax = pr;
				}
			}
			sb.append(main.get(plMax).i);	sb.append(" ");
			sb.append(main.get(plMax).j);	sb.append(" ");
			sb.append(main.get(prMax).i);	sb.append(" ");
			sb.append(main.get(prMax).j);	sb.append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
		
	}
	
}


class Pair implements Comparable<Pair>{
	
	static long CCW(Pair p1, Pair p2, Pair p3){
		return 1L * (p2.i - p1.i)*(p3.j - p2.j) - 1L*(p3.i - p2.i)*(p2.j - p1.j);
	}
	
	static long CCW2(Pair p1, Pair p2, Pair p3){
		return 1L * (p2.i - p1.i)*(p3.j - p1.j) - 1L*(p3.i - p1.i)*(p2.j - p1.j);
	}
	
	long i, j;

	Pair(long i, long j){
		this.i = i;	this.j = j;
	}
	
	public static double distance(Pair p1, Pair p2){
		long xd2 = (long)Math.pow((p1.i - p2.i)*1L, 2);
		long yd2 = (long)Math.pow((p1.j - p2.j)*1L, 2);
		return Math.sqrt(xd2+yd2);
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
}

class PairComparator implements Comparator<Pair>{
	
	Pair root = null;
	
	PairComparator(Pair root){
		this.root = root;
	}
	
	@Override
	public int compare(Pair p1, Pair p2){
		long ret = Pair.CCW2(root, p1, p2);
		if(0L < ret)
			return -1;
		else if(ret < 0L)
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

