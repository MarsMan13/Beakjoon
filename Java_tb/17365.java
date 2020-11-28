import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Collections;


class Main{

	String target;
	Trie root;

	static LinkedList<Node> dp = new LinkedList<>();

	public static void main(String[] args){
		new Main();
	}

	class Node implements Comparable<Node>{
		String str;
		int count = 0;

		Node(String str, int count){
			this.str = str;
			this.count = count;
		}

		@Override
		public int compareTo(Node obj){
			return this.str.compareTo(obj.str);
		}
	}

	Main(){

		try{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(bf.readLine());

			root = new Trie();

			for(int i = 0; i<n; i++){
				String str = bf.readLine();
				root.putString(str);
			}

			target = bf.readLine();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		System.out.println(recursiveCounter(0, target.length()));
		//end of init
	}	

	int recursiveCounter(int i, int j){

		Node dpNode = new Node(target.substring(i, j), 0);
		int dpIndex = Collections.binarySearch(dp, dpNode);
		if(dpIndex >= 0){
			return dp.get(dpIndex).count;
		}

		int count = 0;
		int count1;
		
		count += root.searchCompletion(target.substring(i, j));

		for(int k = i+1; k<j; k++){
			count1 = root.searchCompletion(target.substring(i, k));
			if(count1 == 0) continue;
			count += count1 * recursiveCounter(k, j);
		}
		
		dpNode.count = count;
		dp.add(dpNode);
		Collections.sort(dp);
		return count;

	}
}


class Trie{

	final static int ALPHA = 26;
	
	char alpha;
	Trie[] child = new Trie[ALPHA+1];
	int childsNum = 0;
	int count = 0;
	boolean leaf = false;

	////////////////////////

	Trie(){
	}

	Trie(char c){
		this.alpha = c;
	}
	
	int putString(String str){
		Trie newNode = new Trie();
		
		Trie pointer = this;
		for(int i = 0; i<str.length(); i++){
			char eleChar = str.charAt(i);
			
			if(pointer.child[eleChar - 'a'] == null){
				pointer.child[eleChar - 'a'] = new Trie(eleChar);
			}
			pointer.childsNum++;
			pointer = pointer.child[eleChar - 'a'];

		}
		pointer.count++;
		pointer.leaf = true;
		return 1;
	}
	
	int searchCompletion(String str){

		Trie pointer = this;

		for(int i = 0; i<str.length(); i++){
			char eleChar = str.charAt(i);
			if(pointer.child[eleChar - 'a'] == null){
				return 0;
			}
			pointer = pointer.child[eleChar - 'a'];
		}
		return pointer.childsNum + pointer.count;
		
	}


	Trie getString(String str){
		
		Trie pointer = this;

		for(int i = 0; i<str.length(); i++){
			char eleChar = str.charAt(i);
			if(pointer.child[eleChar - 'a'] == null){
				return null;
			}
			pointer = pointer.child[eleChar - 'a'];
		}
		
		if(pointer.leaf){
			return pointer;
		}
		return null;
	}

	@Override
	public String toString(){
		return "" + this.alpha;
	}
}
