import java.util.*;
import java.io.*;



class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bf.readLine());
		int[] result = new int[t];

		StringTokenizer st;

		for(int i = 0; i<t; i++){
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
		
			int[] delay = new int[n+1];
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=n; j++){
				delay[j] = Integer.parseInt(st.nextToken());
			}
	
			Building[] building = new Building[n+1];
			for(int j = 1; j<=n; j++)	building[j] = new Building(j);
			for(int j = 1; j<=k; j++){
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				building[from].next.add(building[to]);
				building[to].parents++;
			}
	
			int target = Integer.parseInt(bf.readLine());

			// END OF INIT
			// START BFS

			
			Queue<Building> queue = new LinkedList<Building>();
			for(int j = 1; j<=n; j++){
				if(building[j].parents == 0){
					queue.add(building[j]);
				}
			}


			while(!(queue.isEmpty())){
				Building temp = queue.poll();
				for(Iterator<Building> itr = temp.next.iterator(); itr.hasNext(); ){
					Building temp2 = itr.next();

					if(temp2.until < (temp.until + delay[temp.index])){
						temp2.until = temp.until + delay[temp.index];
					}
					temp2.parents--;
					if(temp2.parents == 0){
						queue.offer(temp2);
					}
				}
			}

			// END OF PROCESSING
			result[i] = (building[target].until + delay[target]);
		}

		for(int i = 0; i<t; i++){
			System.out.println(result[i]);
		}

	}

}

class Building{

	int index;

	boolean visited = false;
	int until = 0;

	int parents = 0;
	List<Building> next = new LinkedList<Building>();

	Building(int index){
		this.index = index;
	}

}
