import java.util.*;
import java.io.*;



class Main{

	static int N;
	static int M;

	static Node[] nodes = null;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		nodes = new Node[N+1];
		
		StringTokenizer st = null;
		for(int i = 1; i<=N; i++){
			nodes[i] = new Node(i);
		}
		for(int i = 1; i<=N; i++){
		
			st = new StringTokenizer(bf.readLine());
			int j = i;
			while(st.hasMoreTokens()){
				j = Integer.parseInt(st.nextToken());
				
				if(j == 0)
					break;

				nodes[i].child.add(nodes[j]);
				nodes[j].child.add(nodes[i]);
			}
		}

		Queue<Node> queue = new LinkedList<>();

		M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<M; i++){
			int index = Integer.parseInt(st.nextToken());
			nodes[index].makeRumor(0);	
			queue.offer(nodes[index]);
		}

		// END OF INIT


		while(!(queue.isEmpty())){
			Node temp = queue.poll();
			for(Iterator<Node> itr = temp.child.iterator(); itr.hasNext() ;){
				Node tempNode = itr.next();
				tempNode.count++;
				if((tempNode.count >= (tempNode.child.size() + 1)/2 ) && !(tempNode.rumored)){
					tempNode.makeRumor(temp.time+1);
					queue.offer(tempNode);
				}
			}
		}

		for(int i = 1; i<=N; i++){
			System.out.print(nodes[i].time+" ");
		}



	}
}

class Node{

	LinkedList<Node> child = new LinkedList<>();
	int index;
	int count = 0;
	boolean rumored = false;
	int time = -1;

	Node(int index){
		this.index = index;
	}

	void makeRumor(int time){
		this.time = time;
		this.rumored = true;
	}
}
