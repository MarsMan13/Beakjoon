import java.util.*;
import java.io.*;



class Main{

	static int N = 0;
	static int[] height = null;
	static Tree[] tree = null;

	public static void main(String[] args) throws IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		height = new int[N+1];
		tree = new Tree[N+1];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			height[i] = Integer.parseInt(st.nextToken());
			tree[i] = new Tree(height[i]);
		}

		// END OF INIT
		//

		long gap = Tree.totTwo - Tree.totOne;
		if((0 <= gap) && (gap%3 == 0)){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}

	}
}

class Tree{

	static long totOne = 0;
	static long totTwo = 0;

	int height;
	int one = 0;
	int two = 0;

	Tree(int height){
		this.height = height;
		
		one = height%2;
		two = height/2;

		totOne += one;
		totTwo += two;
	}
}
