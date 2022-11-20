import java.util.*;
import java.io.*;

class Main{
	
	static String input;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		input = bf.readLine();
		int temp = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);
		for(int start = 0; start < input.length(); start++){
			char c = input.charAt(start);
			if(c == '('){
				int top = stack.pop();
				stack.push(top-1);
				stack.push((input.charAt(start-1) - '0'));
				stack.push(0);
			}
			else if(c == ')'){
				int layerSum = stack.pop();
				int multi = stack.pop();
				int top = stack.pop() + layerSum * multi;
				stack.push(top);
			}
			else{
				int top = stack.pop();
				stack.push(top+1);
			}
		}
		System.out.println(stack.pop());
	}
}