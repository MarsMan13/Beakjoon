import java.util.*;
import java.io.*;

class Main{

	static char[] T = new char[1001];
	static int lengthT = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		char[] S = new char[1001];
		int lengthS = 0;
		{
			char[] tempS = st.nextToken().toCharArray();
			for(int i = 0; i<tempS.length; i++)
				S[i] = tempS[i];
			lengthS = tempS.length;
		}		
		st = new StringTokenizer(bf.readLine());
		{
			char[] tempT = st.nextToken().toCharArray();
			for(int i = 0; i<tempT.length; i++)
				T[i] = tempT[i];
			lengthT = tempT.length;
		}	
		// END OF INIT
		System.out.println(dfs(S, lengthS));
	}

	public static int dfs(char[] S, int lengthS){
		if(lengthS == lengthT){
			for(int i = 0; i<lengthS; i++){
				if(!(T[i] == S[i]))	return 0;
			}
			return 1;
		}		
		// Do operator1
		lengthS = operator1(S, lengthS);
		if(dfs(S, lengthS) == 1) return 1;
		lengthS = deoperator1(S, lengthS);
		// Do operator2
		lengthS = operator2(S, lengthS);
		if(dfs(S, lengthS) == 1) return 1;
		lengthS = deoperator2(S, lengthS);
	
		return 0;
	}

	public static int operator1(char[] S, int lengthS){
		S[lengthS] = 'A';
		return lengthS+1;
	}

	public static int deoperator1(char[] S, int lengthS){
		return lengthS-1;
	}

	public static int operator2(char[] S, int lengthS){
		for(int i = 0; i<lengthS/2; i++){
			char temp = S[i];
			S[i] = S[lengthS - i - 1];
			S[lengthS - i - 1] = temp;
		}
		S[lengthS] = 'B';
		return lengthS+1;
	}

	public static int deoperator2(char[] S, int lengthS){
		lengthS--;
		for(int i = 0; i<lengthS/2; i++){
			char temp = S[i];
			S[i] = S[lengthS - i - 1];
			S[lengthS - i - 1] = temp;
		}
		return lengthS;
	}
}