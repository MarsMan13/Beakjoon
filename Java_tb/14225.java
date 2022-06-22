import java.util.*;
import java.io.*;


class Main{

	static int N = 0;
	static int[] inputs = null;
	static int[] check = new int[20 * 100000];

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		inputs = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++)
			inputs[i] = Integer.parseInt(st.nextToken());
		//
		recursive(0, 0);
		for(int i = 1; i<check.length; i++)
			if(check[i] == 0){
				System.out.println(i);
				break;
			}
	}

	public static void recursive(int index, int tot){
		if(index == N){
			check[tot] = 1;
			return;
		}
		//	if selected
		recursive(index+1, tot+inputs[index]);	
		//	if not selected
		recursive(index+1, tot);
	}
}
