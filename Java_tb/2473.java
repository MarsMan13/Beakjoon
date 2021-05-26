import java.util.*;
import java.io.*;

class Main{
	
	static int N;
	static TreeSet<Long> set = new TreeSet<>();
	static long[] inputs = null;
	static final long MAX = 1000000000L;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		inputs = new long[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			inputs[i] = Long.parseLong(st.nextToken());
			set.add(inputs[i]);
		}
		
		//
		
		long ret = MAX*3 + 1;
		long[] ret2 = new long[3];
		for(int i = 0; i<N; i++){
			for(int j = i+1; j<N; j++){
				set.remove(inputs[i]);
				set.remove(inputs[j]);
				
				long sum = inputs[i] + inputs[j];
					
				long need = sum * -1;
				
				long target1 = MAX+1;
				long target2 = MAX+1;
				
				Long target1L = set.ceiling(need);
				if(target1L != null)
					target1 = target1L;
				Long target2L = set.floor(need);
				if(target2L != null)
					target2 = target2L;
				
				
				long target = 0L;
				if(Math.abs(sum+target1) < Math.abs(sum+target2)){
					sum += target1;
					target = target1;
				}
				else{
					sum += target2;
					target = target2;
				} 
				
				if(Math.abs(sum) < ret){
					ret = Math.abs(sum);
					ret2[0] = inputs[i];
					ret2[1] = inputs[j];
					ret2[2] = target;
				}
				
				set.add(inputs[i]);
				set.add(inputs[j]);
			}
		}
		Arrays.sort(ret2);
		System.out.println(ret2[0] + " " + ret2[1] + " " + ret2[2]);
	}
}
	