import java.util.*;
import java.io.*;


class Main{

	static int[] data;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> list;


		int t = Integer.parseInt(bf.readLine());

		for(int i = 0; i<t; i++){
			
			int n = Integer.parseInt(bf.readLine());
			data = new int[n+1];
			list = new LinkedList<>();
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<n; j++){
				data[j] = Integer.parseInt(st.nextToken());
			}
		
			// END OF INIT

			int k = 0;
			for(int j = 0; j<n; j++){
				if(data[j] == 0){
					if(k == 0){
						list.add(new Node(k, j-1));
						k = j;
					}
					else{
						list.add(new Node(k, ));
					}
				}
			}
		}


	}
}


class Node{
	int start;
	int end;

	Node(int a, int b){
		this.start = a;
		this.end = b;
	}
}
