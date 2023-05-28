import java.util.*;
import java.io.*;

class Main{
	static int N; // < 50
	static List<Integer> pos = new ArrayList<>();
	static List<Integer> neg = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(bf.readLine());
		int answer = 0;
		int zero = 0;
		for(int i = 0; i<N; i++){
			int temp = Integer.parseInt(bf.readLine());
			if(temp == 1){
				answer++;
			}
			else if(0 < temp){
				pos.add(temp);
			}
			else if(temp < 0){
				neg.add(temp);
			}
			else zero = 1;
		}
		//

		Collections.sort(pos);
		Collections.sort(neg);
		if(pos.size() % 2 == 1){
			answer += pos.remove(0);
		}
		if(neg.size() % 2 == 1){
			if(0 < zero)
				neg.remove(neg.size() - 1);
			else
				answer += neg.remove(neg.size() - 1);
		}
		
		// Pos
		for(int i = pos.size() - 1; 0 < i; i-=2){
			answer += pos.get(i) * pos.get(i-1);
		}
		// Neg
		for(int i = 0; i < neg.size(); i+=2){
			answer += neg.get(i) * neg.get(i+1);
		}
		System.out.println(answer);
	}
}