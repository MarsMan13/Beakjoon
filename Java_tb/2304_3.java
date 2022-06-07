import java.util.*;
import java.io.*;


class Main{

    static int N = 0;
    static Node[] columns = null;

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        columns = new Node[N+2];
        {
            int maxX = 0;
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(bf.readLine());
                int x_ = Integer.parseInt(st.nextToken());
                int y_ = Integer.parseInt(st.nextToken());
                columns[i] = new Node(x_, y_);
                if(maxX < x_)   maxX = x_;
            }
            columns[N] = new Node(0, 0);
            columns[N+1] = new Node(maxX+1, 0);
        }
        Arrays.sort(columns);
        int maxIndex = 0;
        int maxY = 0;
        for(int i = 0; i<=N+1; i++){
            if(maxY < columns[i].y){
                maxIndex = i;
                maxY = columns[i].y;
            }
        }
        // END OF INIT

        int answer = 0;
        List<Node> meaningfulColumns = new ArrayList<>();
        for(int i = 1; i<=N; i++){
            if(i <= )
        }
    }

    public static int isLocalMaximum(Node before, Node cur, Node after){
        //return (before.y <= cur.y) && (cur.y <= after.y);
        return !((cur.y < before.y) && (cur.y < after.y));
    }

    public static int getRectagleSize(Node node1, Node node2){
        int width = (node1.x < node2.x) ? (node2.x - node1.x) : (node1.x - node2.x);
        int height = (node1.y < node2.y) ? node1.y : node2.y;
        return width * height;
    }
}

class Node implements Comparable<Node>{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o){
        return this.x - o.x;
    }

    @Override
    public String toString(){
        return "x: "+this.x+", y: "+this.y;
    }
}