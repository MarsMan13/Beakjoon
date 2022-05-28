import java.util.*;
import java.io.*;



class Main{
    
    static int N;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        
        
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            int input = Integer.parseInt(bf.readLine());
            if(max_pq.size() == min_pq.size()){
                max_pq.offer(input);
            } 
            else{
                min_pq.offer(input); 
            }
            Integer mins = min_pq.poll();
            Integer maxs = max_pq.poll();
            if(mins != null && maxs != null){
                if(mins < maxs){
                    Integer temp = mins;
                    mins = maxs;
                    maxs = temp;
                }
            }
            if(mins != null)
                min_pq.offer(mins);
            if(maxs != null)
                max_pq.offer(maxs);
            sb.append(max_pq.peek());    sb.append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

