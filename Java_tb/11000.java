import java.util.*;
import java.io.*;


class Main{


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
        }
    }
}

class Class_ implements Comparable<Class_>{
    int start, end;
    Class_(int s, int e){
        this.start = s;
        this.end = e;
    }

    @Override
    public int compareTo(Class_ o){
        return this.end - o.end;
    }
}