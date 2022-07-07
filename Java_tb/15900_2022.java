import java.util.*;
import java.io.*;


class Main{

    static int count = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        Node.nodes = new Node[N+1];
        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Node.getInstance(a).connected.add(Node.getInstance(b));
            Node.getInstance(b).connected.add(Node.getInstance(a));
        }
        // END OF INIT
        dfs(1, 0);
        System.out.println((count % 2 == 1 ? "Yes" : "No"));
    }

    static void dfs(int index, int distance){
        Node curNode = Node.getInstance(index);
        curNode.visited = 1;

        int isLeaf = 1;
        for(Node o : curNode.connected){
            if(o.visited == 0){
                isLeaf = 0;
                dfs(o.id, distance+1);
            }
        }
        //
        if(isLeaf == 1)
            count += distance;
    }
}

class Node{
    static Node[] nodes = null;
    static public Node getInstance(int id){
        if(nodes[id] == null)
            nodes[id] = new Node(id);
        return nodes[id];
    }

    int id;
    int visited = 0;
    List<Node> connected = new ArrayList<>();
    private Node(int id){
        this.id = id;
    }
}