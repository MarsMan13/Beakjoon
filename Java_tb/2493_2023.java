import java.util.*;
import java.io.*;

class Main{
	
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		
		Deque<Integer> indexStack = new ArrayDeque<>();
		Deque<Integer> heightStack = new ArrayDeque<>();
		indexStack.push(0);
		heightStack.push(1000000000);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++){
			int curHeight = Integer.parseInt(st.nextToken());

			while(!heightStack.isEmpty() && heightStack.peek() < curHeight){
				indexStack.pop();
				heightStack.pop();
			}
			sb.append(indexStack.peek());
			sb.append(" ");
			indexStack.push(i);
			heightStack.push(curHeight);
		}
		System.out.println(sb.toString());
		
	}
}