import java.util.*;
import java.io.*;

class Main{
	static String input;
	static String bomb;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		input = bf.readLine();
		bomb = bf.readLine();

		Deque<Character> deque = new LinkedList<>();
		for(int i = 0; i<input.length(); i++){
			deque.offerLast(input.charAt(i));

			if(deque.size() >= bomb.length()){
				List dequeList = (LinkedList)deque;
				boolean flag = true;
				for(int j = 0; j<bomb.length(); j++){
					if((Character)dequeList.get(dequeList.size() - 1 - j) != bomb.charAt(bomb.length() - 1 - j)){
						flag = false;
						break;
					}
				}
				if(flag){
					for(int j = 0; j<bomb.length(); j++){
						deque.pollLast();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : deque){
			sb.append(c);
		}
		if(deque.size() == 0){
			System.out.println("FRULA");
		}
		else{
			System.out.println(sb.toString());
		}

	}
}