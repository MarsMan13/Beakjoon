import java.util.*;
import java.io.*;


class Main{
    
    static int N, M;
    static Node[] nodes = null;
    static TreeMap<Integer, Node> usables = new TreeMap<>();
    
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
           
            nodes[from].latter = to;
            nodes[to].former = from;
            nodes[to].usable = 0;
        }
       
        for(int i = 1; i<=N; i++){
            if(nodes[i].usable == 1){
                usables.put(i, nodes[i]);
            }
        }
        // END OF INIT
        
        StringBuilder sb = new StringBuilder();
        while(!(usables.isEmpty())){
            int firstKey = usables.firstKey();
            Node firstValue = nodes[firstKey];
            
            sb.append(firstKey);
            sb.append(" ");
            usables.remove(firstKey);
            
            if(firstValue.latter == 0) continue;
            int nextKey = firstValue.latter;
            Node nextValue = nodes[nextKey];
            nextValue.former = 0;
            nextValue.usable = 1;
            usables.put(nextKey, nextValue);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

class Node{
    int index;
    int former = 0;
    int latter = 0;
    int usable = 1;    // 0 --> false, 1 --> true;
    
    Node(int index){
        this.index = index;
    }
    
    public String toString(){
        return "index: "+index + ", former: "+former+", latter: "+latter;
    }
}