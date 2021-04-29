import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static long[] Ns = null;
	static Long2[] Ms, Ms2;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		Ns = new long[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			Ns[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
	
		M = Integer.parseInt(st.nextToken());
		Ms = new Long2[M];
		Ms2 = new Long2[M];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<M; i++){
			Ms[i] = new Long2(Long.parseLong(st.nextToken()));
			Ms2[i] = Ms[i];
		}
	
		Arrays.sort(Ns); Arrays.sort(Ms);
		
		{
			int i = 0, ii = 0;
			while(i < N && ii < M){
				if(Ns[i] < Ms[ii].value){
					i++;
				}
				else if(Ns[i] == Ms[ii].value){
					Ms[ii].flag = 1;
					i++;
					ii++;
				}
				else{
					ii++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<M; i++){
			if(Ms2[i].flag == 1){
				sb.append("1");
			}
			else
				sb.append("0");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}

class Long2 implements Comparable<Long2>{
	
	long value;
	int flag = 0;
	
	Long2(long v){
		this.value = v;
	}
	
	@Override
	public int compareTo(Long2 o){
		if(this.value < o.value)
			return -1;
		else if(this.value > o.value)
			return 1;
		return 0;
	}
}