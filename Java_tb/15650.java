import java.util.*;



class Main{
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		def1(1, M, new LinkedList<Integer>());
		System.out.println(sb.toString());	
		sc.close();
	}
	
	public static void def1(int start, int rest, LinkedList<Integer> list){
		if(rest == 0){
			for(int i = 0; i<M; i++){
				sb.append(list.get(i));
				sb.append(" ");
			}
			sb.append("\n");
		}
		else{
			for(int i = start; i<=N-rest+1; i++){
				list.add(i);
				def1(i+1, rest-1, list);
				list.remove(list.size() - 1);
			}
		}
	}
}