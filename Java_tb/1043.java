import java.util.*;
import java.io.*;


class Main{
	
	static int N, M, K;
	static List<Integer> knower = new ArrayList<>();
	
	static TreeMap<Integer, List<Integer>> people = new TreeMap<>();	//people : party
	static TreeMap<Integer, List<Integer>> party = new TreeMap<>();		//party : people
	static int[] trueParty = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trueParty = new int[M+1];	// 1 <= party 	
		for(int i = 1; i<=N; i++){
			people.put(i, new ArrayList<>());
		}
		for(int i = 1; i<=M; i++){
			party.put(i, new ArrayList<>());
		}
		
		st = new StringTokenizer(bf.readLine());
		K = Integer.parseInt(st.nextToken());
		for(int i = 0; i<K; i++){
			knower.add(Integer.parseInt(st.nextToken()));	
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i<=M; i++){
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j<num; j++){
				int person = Integer.parseInt(st.nextToken());
				people.get(person).add(i);
				party.get(i).add(person);
				if(knower.contains(person)){
					queue.add(i);
					trueParty[i] = 1;
				}
			}
		}
	
		while(!(queue.isEmpty())){
			int tempParty = queue.poll();
			List<Integer> peopleWhoStand = party.get(tempParty);
			List<Integer> addedParty = new LinkedList<>();
			for(int person : peopleWhoStand){
				addedParty.addAll(
					people.get(person)
				);
			}
			for(int party : addedParty){
				if(trueParty[party] == 0){
					trueParty[party] = 1;
					queue.offer(party);
				}
			}
		}
		int count = 0;
		for(int i = 1; i<=M; i++){
			if(trueParty[i] == 0)
				count++;
		}
		System.out.println(count);
		
	}
}



