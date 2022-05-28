import java.util.*;
import java.io.*;


class Main{
    
    static int N, M;
    static Node[] nodes = null;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nodes = new Node[N+1];
        for(int i = 1; i<=N; i++){
            nodes[i] = new Node(i);
        }
        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[from].nexts.add(nodes[to]);
            nodes[to].parents++;
        }
        // END OF INIT;
        
        TreeSet<Node> set = new TreeSet<>();
        for(int i = 1; i<=N; i++){
            if(nodes[i].parents == 0){
                set.add(nodes[i]);
            }
        }
        // END OF INIT
        StringBuilder sb = new StringBuilder();
        while(!(set.isEmpty())){
            Node target = set.first();
            sb.append(target.index);
            sb.append(" ");
            for(Iterator<Node> itr = target.nexts.iterator(); itr.hasNext(); ){
                Node temp = itr.next();
                temp.parents--;
                if(temp.parents == 0){
                    set.add(temp);
                }
            }
            set.remove(target);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
    }
}

class Node implements Comparable<Node>{
    int index;
    TreeSet<Node> nexts = new TreeSet<Node>();
    int parents = 0;
    
    Node(int index){
        this.index = index;
    }
    
    @Override
    public int compareTo(Node o){
        return this.index - o.index;
    }
}