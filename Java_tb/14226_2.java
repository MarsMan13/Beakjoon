import java.util.*;


class Main{

	static int S;
	static int[] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();	sc.close();
		dp = new int[S+1];	Arrays.fill(dp, 1000000);
		//
	
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(1, 0, 0));
		while(!(queue.isEmpty())){
			Pair cur = queue.poll();
			if(cur.i == S){
				System.out.println(cur.j);
				break;
			}
			
		}
	}

}

class Node{
	int i, j, c;
	Node(int i, int j, int c){
		this.i = i;	this.j = j;
		this.c = c;
	}
}