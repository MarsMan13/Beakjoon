import java.util.*;
import java.io.*;

class Main {
   
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 0){
                Integer temp = pq.poll();
                if(temp == null)
                    sb.append("-1");
                else
                    sb.append(temp * -1);
                sb.append("\n");
            }
            else
                for(int j = 0; j<a; j++)
                    pq.offer(Integer.parseInt(st.nextToken()) * -1);
        }
        System.out.println(sb.toString());
    }
}
