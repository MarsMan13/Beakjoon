import java.util.*;
import java.io.*;



class Main{
	
	static int N = 0;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = null;
		List<Man> list = new ArrayList<>();
		for(int i = 0; i<N; i++){
		
			st = new StringTokenizer(bf.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Man(name, age));
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(Man m : list){
			sb.append(m.age);
			sb.append(" ");
			sb.append(m.name);
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}


class Man implements Comparable<Man>{
	
	String name;
	int age;
	int no;
	
	static int noCounter = 0;
	
	Man(String name, int age){
		this.name = name;
		this.age = age;
		this.no = noCounter++;
	}
	
	@Override
	public int compareTo(Man o){
		if(this.age == o.age){
			return this.no - o.no;
		}
		return this.age - o.age;
	}
	
}