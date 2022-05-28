import java.util.*;
import java.io.*;


class Main{
	static StringBuilder sb = new StringBuilder();

	static int N;
	static double K;
	static int[] input = null;
	static int[] dp = null;		// stores max length (<= 500) 
	static double[] dp2 = null;	// The number of possible case of index 
	static int max = 0;
	static int[] value2Index = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());	K = Double.parseDouble(st.nextToken());
			input = new int[N+1];	
			dp = new int[N+1];	Arrays.fill(dp, 1);
			dp2 = new double[N+1];
			for(int i = 1; i<=N; i++)	dp2[i] = 1.0;
			st = new StringTokenizer(bf.readLine());
			value2Index = new int[100001];
			for(int i = 1; i<=N; i++){
				input[i] = Integer.parseInt(st.nextToken());
				value2Index[input[i]] = i;
			}
			//
			max = 1;
			def(N);
			sb.append(max);	sb.append("\n");
			// skip == K
			for(Iterator<Integer> itr = def2(1, max, 0, new ArrayList<Integer>(max)).iterator(); itr.hasNext(); ){
				sb.append(itr.next());	sb.append(" ");
			}
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static List<Integer> def2(int index, int count, int limit, List<Integer> output){
		
		// stores indexes of targets s.t sorted by dict order;
		List<Integer> targets = new LinkedList<>();
		for(int i = index; i<=N; i++){
			if(limit < input[i] && dp[i] == count){
				targets.add(input[i]);
			}
		}
		Collections.sort(targets);
		for(Iterator<Integer> itr = targets.iterator(); itr.hasNext(); ){
			int tempValue = itr.next();
			if(dp2[value2Index[tempValue]] < K){
				K -= dp2[value2Index[tempValue]];
			}
			else{
				output.add(tempValue);
				return def2(value2Index[tempValue]+1, count-1, tempValue, output);
			}
		}
		return output;
	}	
	
	public static void def(int index){
		
		if(index == 0)	return;
	
		for(int i = N; index < i; i--){
			if(input[index] < input[i]){
				if(dp[index] < dp[i] + 1){
					dp[index] = dp[i] + 1;
					max = Math.max(max, dp[index]);
					dp2[index] = dp2[i];
				}
				else if(dp[index] == dp[i] + 1){
					dp2[index] += dp2[i];
				}
			}
		}	
		def(index-1);
	}
}