import java.util.*;
import java.io.*;

class Main{
	
	static int N;
	static int[] inputs = new int[]{0,0,0};
	static Map<Triple, Integer> mem = new TreeMap<>();

	static int[][] combi3 = new int[][]{
		{0, 1, 2},
		{0, 2, 1},
		{1, 0, 2},
		{1, 2, 0},
		{2, 0, 1},
		{2, 1, 0},
	};
	static int[] damages = new int[]{9, 3, 1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		// END OF INIT

		// 0, 0, 0 넣기
		mem.put(new Triple(0, 0, 0), 0);
		for(int i = 0; i<=60; i++){
			for(int j = 0; j<=60; j++){
				for(int k = 0; k<=60; k++){
					if(i == 0 && j == 0 && k == 0)	continue;
					//
					int tempMin = -1;
					// 뮤탈이 마린을 때리는 모든 경우(3x2x1의 경우의 수)
					for(int c = 0; c<combi3.length; c++){
						int ii = i - damages[combi3[c][0]];
						int jj = j - damages[combi3[c][1]];
						int kk = k - damages[combi3[c][2]];

						int temp = mem.get(new Triple(
								(ii <= 0 ? 0 : ii),
								(jj <= 0 ? 0 : jj),
								(kk <= 0 ? 0 : kk)
						)) + 1;
						// 최적의 값 찾기
						if(tempMin == -1 || temp < tempMin)
							tempMin = temp;
					}
					mem.put(
						new Triple(i, j, k),
						tempMin
					);
				}
			}
		}
		System.out.println(mem.get(new Triple(inputs[0], inputs[1], inputs[2])));
	}
}

class Triple implements Comparable<Triple>{
	int a, b, c;
	Triple(int a, int b, int c){
		this.a = a; this.b = b; this.c = c;
	}

	@Override
	public int compareTo(Triple o){
		int id1 = 10000 * this.a + 100 * this.b + this.c;
		int id2 = 10000 * o.a + 100 * o.b + o.c;
		return id1 - id2;
	}
}