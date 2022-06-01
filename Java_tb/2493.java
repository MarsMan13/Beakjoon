import java.util.*;
import java.io.*;


class Main {

    static int N = 0;
    static List<Node> nodes = new ArrayList<>();    // This is an issue!!!!!@@@@@@
    static TreeSet<Node> tree = new TreeSet<>(); 
    
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for(int i = 1; i<=N; i++){
            nodes.add(new Node(i, Integer.parseInt(st.nextToken())));
        }
        Collections.sort(nodes, new NodeComparator());
        Collections.reverse(nodes);
        // for(int i = 1; i<=N; i++){
        //     System.out.println(nodes.get(i-1));
        // }

        //
        int[] answers = new int[N+1];
        for(int i = 0; i<N; i++){
            Node target = nodes.get(i);
            if(!tree.isEmpty()){
                Node floor = tree.floor(target);
                if(floor != null){
                    answers[target.coord] = floor.coord;
                }
            }
            tree.add(target);
       }
       //
       StringBuilder sb = new StringBuilder();
       for(int i = 1; i<=N; i++){
           sb.append(answers[i]);
           if(i != N)
                sb.append(" ");
       }
       System.out.println(sb);
    }

}

class NodeComparator implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        return o1.height - o2.height;
    }
}

class Node implements Comparable<Node>{

    int coord, height;
    Node(int coord, int height){
        this.coord = coord;
        this.height = height;
    } 

    @Override
    public int compareTo(Node o) {
        return this.coord - o.coord;    
    }

    @Override
    public String toString(){
        return "coord: "+this.coord+", height: "+this.height;
    }
}