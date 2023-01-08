import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String input = bf.readLine();
		Deque<Character> stack = new ArrayDeque<>();

		int deleted = 0;
		for(int i = 0; i<input.length(); i++){
			char c = input.charAt(i);
			if(stack.isEmpty()){
				stack.push(c);
			}
			else if(stack.peek() < c && deleted < K){
				while(!stack.isEmpty() && stack.peek() < c && deleted < K){
					stack.pop();
					deleted++;
				}
				stack.push(c);
			}
			else{
				stack.push(c);
			}
		}
		while(deleted < K){
			stack.pop();
			deleted++;
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
			sb.append(stack.pollLast());
		System.out.println(sb.toString());
	}
}