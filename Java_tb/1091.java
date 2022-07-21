import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		Cards cards = new Cards(N);
		//
		st = new StringTokenizer(bf.readLine());
		int[] pSeq = new int[N];
		for(int i = 0; i<N; i++){
			pSeq[i] = Integer.parseInt(st.nextToken());
		}
		//
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			cards.seq[i] = Integer.parseInt(st.nextToken());
		}
		//
		for(int count = 0; count<1000000; count++){
			if(cards.compareCards(pSeq)){
				System.out.println(count);
				return;
			}
			cards.shuffle();
		}
		System.out.println(-1);
	}
}

class Cards{
	int N;
	int[] cards = null;
	int[] seq = null;

	Cards(int N){
		this.N = N;
		cards = new int[N];
		seq = new int[N];
		for(int i = 0; i<N; i++)	
			cards[i] = i;
	}

	public void shuffle(){
		int[] cards_ = new int[N];

		for(int i = 0; i<N; i++){
			cards_[seq[i]] = cards[i];
		}
		cards = cards_;
	}

	public boolean compareCards(int[] pSeq){
		for(int i = 0; i<N; i++)
			if((i%3) != pSeq[cards[i]])
				return false;
		return true;
	}
}