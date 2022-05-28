import java.util.*;
import java.io.*;



class Main{
	
	static int N = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		List<Meeting> list = new ArrayList<>();
		for(int i = 0; i<N; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			list.add(new Meeting(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);

		int count = 0;
		int lastEnd = 0;
		for(Meeting m : list){
			if(lastEnd <= m.start){
				count++;
				lastEnd = m.end;
			}
		}
		System.out.println(count);
		
	}
}


class Meeting implements Comparable<Meeting>{
	int start;
	int end;
	
	Meeting(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Meeting o){
		if(this.end > o.end)
			return 1;
		else if(this.end < o.end)
			return -1;
		else{
			if(this.start > o.start)
				return 1;
			else if(this.start < o.start)
				return -1;
		}
		return 0;
	}
}

