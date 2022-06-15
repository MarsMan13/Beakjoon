import java.util.*;
import java.io.*;


class Main{
    
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Class_> pqMain = new PriorityQueue<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            Class_ c = new Class_(s, f);
            Class_.addClass(c);
        }
        //
        int count = 0;
        while(!Class_.map.isEmpty()){
            count++;
            Class_ c = Class_.map.firstKey();
            int v = Class_.map.get(c);
            if(v == 1)        Class_.map.remove(c);
            else              Class_.map.put(c, v-1);
            while(true){
                Class_ temp = Class_.map.ceilingKey(new Class_(c.f, c.f));
                if(temp == null)    break;
                
                c = temp;
                v = Class_.map.get(temp);
                if(v == 1)        Class_.map.remove(temp);
                else              Class_.map.put(temp, v-1);
            }
        }
        System.out.println(count);
    }
}

class Class_ implements Comparable<Class_>{
    static TreeMap<Class_, Integer> map = new TreeMap<>();
    
    static void addClass(Class_ c){
        if(map.get(c) == null)
            map.put(c, 1);
        else
            map.put(c, map.get(c)+1);
    }
    
    int s, f, v;
    Class_(int s, int f){
        this.s = s;
        this.f = f;
    }
    
    @Override
    public int compareTo(Class_ o){
        if(this.s != o.s)
            return this.s - o.s;
        return this.f - o.f;
    }
    
    @Override
    public String toString(){
        return "s: "+this.s+", f: "+this.f;
    }
}