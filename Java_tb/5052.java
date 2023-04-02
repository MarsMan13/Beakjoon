import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			int n = Integer.parseInt(bf.readLine());
			Trie trie = new Trie();
			List<String> words = new ArrayList<>();
			for(int i = 0; i<n; i++){
				String word = bf.readLine();
				words.add(word);
				trie.insert(word);
			}
			//
			boolean ok = true;
			for(String word : words){
				int count = trie.getPrevWordCount(word);
				if(count > 1){
					sb.append("NO");
					sb.append("\n");
					ok = false;
					break;
				}
			}
			//
			if(ok){
				sb.append("YES");
				sb.append("\n");
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
		bf.close();
	}
}

class TrieNode{
	private Map<Character, TrieNode> childNodes = new HashMap<>();
	private int count = 0;
	private boolean isLast;

	Map<Character, TrieNode> getChildNodes(){
		return this.childNodes;
	}

	int getCount(){
		return this.count;
	}

	int addOneCount(){
		return ++(this.count);
	}

	boolean isLast(){
		return this.isLast;
	}

	void setLast(boolean b){
		this.isLast = b;
	}
}

class Trie{
	private TrieNode rootNode;

	Trie(){
		rootNode = new TrieNode();
	}

	void insert(String word){
		TrieNode curNode = rootNode;
		for(int i = 0; i<word.length(); i++){
			curNode = curNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			curNode.addOneCount();
		}
		curNode.setLast(true);
	}

	int getPrevWordCount(String word){
		TrieNode curNode = rootNode;
		for(int i = 0; i<word.length(); i++){
			char c = word.charAt(i);
			TrieNode node = curNode.getChildNodes().get(c);
			if(node == null){
				return 0;
			}
			curNode = node;
		}
		return curNode.getCount();
	}
}