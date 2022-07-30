import java.util.*;
import java.io.*;


class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int i = 0; i<N; i++)
                pq.offer(new Node(Long.parseLong(st.nextToken())));
            //
            long count = 0;
            while(pq.size() > 1){
                Node node1 = pq.poll();
                Node node2 = pq.poll();
                count += node1.value + node2.value;
                pq.offer(Node.add(node1, node2));
            }
            sb.append(count);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

class Node implements Comparable<Node>{
    long value;
    Node(long value){
        this.value = value;
    }

    static Node add(Node node1, Node node2){
        return new Node(node1.value + node2.value);
    }

    @Override
    public int compareTo(Node o){
        if(this.value > o.value)
            return 1;
        else if(this.value < o.value)
            return -1;
        return 0;
    }
}