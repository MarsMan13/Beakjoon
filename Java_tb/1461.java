import java.util.*;
import java.io.*;

class Main{

	static int N, M;
	static ArrayList<Integer> posBooks = new ArrayList<>();
	static ArrayList<Integer> negBooks = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			int temp = Integer.parseInt(st.nextToken());
			if(temp > 0)		posBooks.add(temp);
			else if(temp < 0)	negBooks.add(temp * -1);
		}
		posBooks.add(0);	negBooks.add(0);
		Collections.sort(posBooks);
		Collections.sort(negBooks);
		// END OF INIT
		// STEP1 : Which direction is far?
		ArrayList<Integer> targetBooks = posBooks;
		int result = 0;
		if(posBooks.get(posBooks.size() - 1) < negBooks.get(negBooks.size() - 1)){
			targetBooks = negBooks;
		}
		// Last pang
		result += goFar(targetBooks, M);
		///////////////////////////////////////
		// STEP2
		for(; !posBooks.isEmpty(); ){
			result += goFar(posBooks, M) * 2;
		}
		for(; !negBooks.isEmpty(); ){
			result += goFar(negBooks, M) * 2;
		}
		System.out.println(result);
	}

	public static int goFar(ArrayList<Integer> list, int bagSize){
		if(list.isEmpty())	return 0;
		int ret = list.get(list.size() - 1);
		for(int i = 0; i<bagSize && !list.isEmpty(); i++){
			list.remove(list.size() - 1);
		}
		return ret;
	}
}