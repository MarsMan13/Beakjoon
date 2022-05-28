import java.util.*;
import java.io.*;


class Main{
	
	static int n;
	static int[] inorder = null;
	static int[] postorder = null;
	static int[] inorder_index = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
	
		inorder = new int[n+1];
		postorder = new int[n+1];
		inorder_index = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=n; i++){
			inorder[i] = Integer.parseInt(st.nextToken());
			inorder_index[inorder[i]] = i;
		}
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=n; i++){
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		// END OF INIT
		
		def1(1, n, 1, n);
		System.out.println(sb.toString());
	}
	
	public static void def1(int s1, int e1, int s2, int e2){
	
		int in_s1 = s1, in_e1, in_s2, in_e2 = e1;
		
		int root_value = postorder[e2];
		sb.append(root_value);	sb.append(" ");
		
		int mid = inorder_index[root_value];
		in_e1 = mid-1;
		if(in_e1 < s1){
			in_s1 = 0;
			in_e1 = 0;
		}
		in_s2 = mid+1;
		if(e1 < in_s2){
			in_s2 = 0;
			in_e2 = 0;
		}
		// END OF INORDER
		int leftSize = 0;
		if(in_s1 != 0){
			leftSize = mid - s1;
			def1(in_s1, in_e1, s2, s2 + leftSize - 1);
		}
		int rightSize = 0;
		if(in_s2 != 0){
			rightSize = e1 - mid;
			def1(in_s2, in_e2, s2 + leftSize, s2 + leftSize + rightSize-1);
		}
		
	}
}


