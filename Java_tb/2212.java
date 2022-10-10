import java.util.*;
import java.io.*;

class Main{
	static int N, K;	
	static List<Integer> sensors = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		K = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			int x = Integer.parseInt(st.nextToken());
			sensors.add(x);
		}
		// END OF INIT
		Collections.sort(sensors);
		List<Integer> diff = new ArrayList<>();
		for(int i = 0; i<sensors.size()-1; i++){
			diff.add(sensors.get(i+1) - sensors.get(i));
		}
		Collections.sort(diff);
		int sum = 0;
		for(int i = 0; i<=diff.size() - K; i++){
			sum += diff.get(i);
		}
		System.out.println(sum);
	}
}
