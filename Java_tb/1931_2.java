import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer((bf.readLine()));
        int N = Integer.parseInt(st.nextToken());
       
        PriorityQueue<Class_> pq = new PriorityQueue<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            pq.offer(new Class_(s, f));
        }
        //
        int count = 0;
        Class_ lastPeek = null;
        while(!pq.isEmpty()){
            Class_ temp = pq.poll();
            if(lastPeek == null || lastPeek.f <= temp.s){
                count++;
                lastPeek = temp;
            }
        }
        System.out.println(count);
    }
}

class Class_ implements Comparable<Class_>{
    int s, f;
    Class_(int s, int f){
        this.s = s;
        this.f = f;
    }

    @Override
    public int compareTo(Class_ o){
        if(this.f != o.f)
            return this.f - o.f;
        return this.s - o.s;
    }
}
