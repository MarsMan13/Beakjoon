import java.util.*;
import java.io.*;

class Main{
	
	static int N;
	static int[] array;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		array = new int[N];
		for(int i = 0; i<N; i++){
			array[i] = Integer.parseInt(st.nextToken());
		}
		// END OF INIT
		Deque<Integer> stack = new ArrayDeque<>();
		int results[] = new int[N];
		Arrays.fill(results, -1);
		stack.push(array[N-1]);
		for(int i = N-1; 0<=i; i--){
			int curTop = array[i];
			while(!stack.isEmpty()){
				if(curTop < stack.peek()){
					results[i] = stack.peek();
					break;
				}
				stack.pop();
			}	
			stack.push(curTop);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++){
			sb.append(results[i]);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}