import java.util.*;
import java.io.*;



class Main{

	static Matrix[] input = null;
	static Matrix[][] mem = null;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		input = new Matrix[N];
		mem = new Matrix[N][N];
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			input[i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// END OF INIT

		System.out.println(def1(0, N-1));
		
	}

	static Matrix def1(int from, int to){
		
		if(from == to){
			return input[from];
		}
		if(mem[from][to] != null){
			return mem[from][to];
		}

		// START OF PROCESS

		int minCount = -1;
		int leftV = -1;
		int rightV = -1;
		for(int i = from; i<to; i++){
			Matrix left = def1(from, i);
			Matrix right = def1(i+1, to);
			
			int tempCount = left.a * left.b * right.b + left.count + right.count;
			if(minCount == -1 || tempCount < minCount){
				minCount = tempCount;
				leftV = left.a;
				rightV = right.b;
			}
		}
		mem[from][to] = new Matrix(leftV, rightV, minCount);	
		
		return mem[from][to];
	}
}


class Matrix{
	int a;
	int b;
	int count = 0;
	Matrix(int a, int b){
		this.a = a;
		this.b = b;
	}
	Matrix(int a, int b, int count){
		this.a = a;
		this.b = b;
		this.count = count;
	}
	@Override
	public String toString(){
		return this.count+"";
	}
}

