import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            long value = Long.parseLong(bf.readLine());
            if(value == 0L){
                if(pq.isEmpty())    sb.append("0");
                else                sb.append(pq.poll().value);
                sb.append("\n");
            }
            else    pq.offer(new Node(value));
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }
}

class Node implements Comparable<Node>{

    long value;
    Node(long value){this.value = value;}
    @Override
    public int compareTo(Node o){
        if(Math.abs(this.value) != Math.abs(o.value))
            return Math.abs(this.value) - Math.abs(o.value) > 0L ? 1 : -1;
        return (this.value - o.value) >= 0L ? 1 : -1; 
    }
}
