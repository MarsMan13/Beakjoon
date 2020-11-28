import java.util.*;
import java.io.*;


class Main{

	static int N;
	static int M;
	static Queue<Moem> queue = new LinkedList<>();
	static int[] pp;
	static int[] bad;
	static ArrayList<Integer> good = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pp = new int[N+1];
		bad = new int[N+1];
		for(int i = 1; i<=N; i++){
			bad[i] = 1;
		}

		int k = 0;
		for(int i = 0; i<M; i++){
			st = new StringTokenizer(bf.readLine());
			k = Integer.parseInt(st.nextToken());
			Moem temp = new Moem(k);
			for(int j = 0; j<k ; j++){
				temp.pp.add(Integer.parseInt(st.nextToken()));	
			}
			queue.offer(temp);
		}

		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=N; i++){
			pp[i] = Integer.parseInt(st.nextToken());
			if(pp[i] == 0){
				good.add(i);
			}
		}
	
		// END OF INIT
		int baam = 0;
outer:
		while(!(queue.isEmpty())){
			Moem temp = queue.poll();

			int clean = 0;
			for(Iterator<Integer> itr = temp.pp.iterator(); itr.hasNext(); ){
				int i = itr.next();
				if(good.contains(i)){
					clean = 1;
				}
				if(clean == 1 && !good.contains(i)){
					baam = 1;
					break outer;
				}
			}
			if(clean == 1){
				for(Iterator<Integer> itr = temp.pp.iterator(); itr.hasNext(); ){
					int i = itr.next();
					bad[i] = 0;
				}
			}
		}

		if(baam == 1){
			System.out.println("NO");
			return;
		}
		System.out.println("YES");
		for(int i = 1; i<=N; i++){
			System.out.print(bad[i]+" ");
		}
		System.out.println();



	}
}

class Moem{
	int ppNum = 0;
	LinkedList<Integer> pp = new LinkedList<>();

	Moem(int k){
		this.ppNum = k;
	}
}
