import java.util.*;
import java.io.*;


class Main{
	
	static String input;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
	
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<input.length(); i++){
			char target = input.charAt(i);
	
			switch(target){
				case '(':
					stack.push(target);
					break;
				case '*':
				case '/':
					while(!(stack.isEmpty()) && (stack.peek() == '*' || stack.peek() == '/')){
						char tempTarget = stack.pop();
						sb.append(tempTarget);
					}
					stack.push(target);
					break;
				case '+':
				case '-':
					while(!(stack.isEmpty()) && stack.peek() != '('){
						char tempTarget = stack.pop();
						sb.append(tempTarget);
					}
					stack.push(target);
					break;
				case ')':
					while(!(stack.isEmpty())){
						char tempTarget = stack.pop();
						if(tempTarget == '(')
							break;
						sb.append(tempTarget);
					}
					break;
				default:
					sb.append(target);
					break;
			}
		}
		while(!(stack.isEmpty())){
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
		sc.close();
		
	}
}