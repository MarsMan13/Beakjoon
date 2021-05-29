import java.util.*;
import java.io.*;
import java.math.*;


class Main{
	
	static int n;
	static int[] A, B, C, D;
	static int[] AB, CD;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		A = new int[n];	B = new int[n];
		C = new int[n];	D = new int[n];
	
		AB = new int[n*n];	CD = new int[n*n];
		
		for(int i = 0; i<n; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		//

		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				AB[n*i + j] = A[i] + B[j];
				CD[n*i + j] = C[i] + D[j];
			}
		}
		
		Arrays.sort(AB);	Arrays.sort(CD);
		Node before1 = null;	Node before2 = null;
		List<Node> AB2 = new ArrayList<>();
		List<Node> CD2 = new ArrayList<>();
		for(int i = 0; i<n*n; i++){
			if(before1 != null){
				if(AB[i] == before1.v){
					before1.count++;
					continue;
				}
			}
			Node newAB = new Node(AB[i]);
			AB2.add(newAB);
			before1 = newAB;
		}	
		for(int i = 0; i<n*n; i++){
			if(before2 != null){
				if(CD[i] == before2.v){
					before2.count++;
					continue;
				}
			}
			Node newCD = new Node(CD[i]);
			CD2.add(newCD);
			before2 = newCD;
		}
		
		BigInteger ret = new BigInteger("0");
		int i = 0;	int j = CD2.size() - 1;
		for(; i<AB2.size(); i++){
			for(; 0 <= j; j--){
				if(AB2.get(i).v <= 0 && (AB2.get(i).v + CD2.get(j).v <= 0))
					break;
				if(AB2.get(i).v > 0 && (AB2.get(i).v + CD2.get(j).v <= 0))
					break;
			}
			
			if(j != -1 && AB2.get(i).v + CD2.get(j).v == 0){
				ret = ret.add(BigInteger.valueOf(AB2.get(i).count).multiply(BigInteger.valueOf(CD2.get(j).count)));
			}
		}
		System.out.println(ret);
	}
}

class Node implements Comparable<Node>{
	int v;
	int count = 1;
	Node(int v){
		this.v = v;
	}
	
	@Override
	public int compareTo(Node o){
		return this.v - o.v;
	}
	
	@Override
	public String toString(){
		return "Node: " + this.v+ " " + this.count;
	}
}
