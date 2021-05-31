import java.util.*;
import java.io.*;


class Main{
	
	static int X;
	
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();	sc.close();
		
		//
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(X, 0, null));
		while(!(queue.isEmpty())){
			Pair cur = queue.poll();
			if(cur.i == 1){
				sb.append(cur.j);	sb.append("\n");
				while(true){
					sb2.insert(0, cur.i);	
					if(cur.from == null)
						break;
					sb2.insert(0, " ");
					cur = cur.from;
				}
				break;
			}
			if(cur.i % 3 == 0){
				queue.offer(new Pair(cur.i/3, cur.j+1, cur));
			}
			if(cur.i % 2 == 0){
				queue.offer(new Pair(cur.i/2, cur.j+1, cur));
			}
			
			if(1 <= cur.i - 1){
				queue.offer(new Pair(cur.i-1, cur.j+1, cur));
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.write(sb2.toString());
		bw.flush();	bw.close();
	}
}

class Pair{
	int i, j;
	Pair from = null;
	Pair(int i, int j, Pair from){
		this.i = i;	this.j = j;
		this.from = from;
	}
}