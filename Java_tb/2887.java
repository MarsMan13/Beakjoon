import java.util.*;
import java.io.*;


class Main{

	static int N = 0;
	static ArrayList<Planet> pList = new ArrayList<>();
	static ArrayList<Tunnel> distance = new ArrayList<>();

	static int[] parent = null;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i = 0; i<=N; i++){
			parent[i] = i;
		}

		int tempX = 0;
		int tempY = 0;
		int tempZ = 0;
		Planet tempP = null;
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());

			tempX = Integer.parseInt(st.nextToken());
			tempY = Integer.parseInt(st.nextToken());
			tempZ = Integer.parseInt(st.nextToken());

			tempP = new Planet(tempX, tempY, tempZ, i);
		
			pList.add(tempP);
		}
		
		Collections.sort(pList, new XComparator());
		tempP = pList.get(0);
		for(int i = 1; i<N; i++){
			tempX = pList.get(i).x;
			distance.add(new Tunnel(tempP.id, pList.get(i).id, Math.abs(tempP.x - tempX)));
			tempP = pList.get(i);
		}	
		Collections.sort(pList, new YComparator());
		tempP = pList.get(0);
		for(int i = 1; i<N; i++){
			tempY = pList.get(i).y;
			distance.add(new Tunnel(tempP.id, pList.get(i).id, Math.abs(tempP.y - tempY)));
			tempP = pList.get(i);
		}	
		Collections.sort(pList, new ZComparator());
		tempP = pList.get(0);
		for(int i = 1; i<N; i++){
			tempZ = pList.get(i).z;
			distance.add(new Tunnel(tempP.id, pList.get(i).id, Math.abs(tempP.z - tempZ)));
			tempP = pList.get(i);
		}
		Collections.sort(distance);	

		int count = 0;
		long ret = 0;
		Tunnel tempT = null;
		for(int i = 0; i<distance.size(); i++){
			tempT = distance.get(i);
			
			if(getParent(tempT.from) != getParent(tempT.to)){
				ret += tempT.cost;
				union(tempT.from, tempT.to);
				count++;
			}

			if(count == N-1)
				break;
		}

		System.out.println(ret);

	}

	static int getParent(int index){
		if(index == parent[index])
			return index;
		return parent[index] = getParent(parent[index]);
	}

	static int union(int a, int b){
		int p1 = getParent(a);
		int p2 = getParent(b);

		parent[p1] = p2;
		
		return 0;
	}

}

class Tunnel implements Comparable<Tunnel>{

	int from;
	int to;
	int cost;

	Tunnel(int from, int to, int cost){
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Tunnel obj){
		return this.cost - obj.cost;
	}
}

class Planet{

	int x;
	int y;
	int z;
	int id;

	Planet(int x, int y, int z, int id){
		this.x = x;
		this.y = y;
		this.z = z;
		this.id = id;
	}

}

class XComparator implements Comparator<Planet>{
	@Override
	public int compare(Planet p1, Planet p2){
		return p1.x - p2.x;
	}
}

class YComparator implements Comparator<Planet>{
	@Override
	public int compare(Planet p1, Planet p2){
		return p1.y - p2.y;
	}
}

class ZComparator implements Comparator<Planet>{
	@Override
	public int compare(Planet p1, Planet p2){
		return p1.z - p2.z;
	}
}
