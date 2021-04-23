import java.util.*;
import java.io.*;


class Main{
    
    
    static int T = 0;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
       
        T = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(bf.readLine());
            List<Integer2> list = new ArrayList<>();
            List<Integer2> list2 = new ArrayList<>();
            for(int j = 0; j<N; j++){
                Integer2 newInt = new Integer2(Integer.parseInt(st.nextToken()));
                list.add(newInt);
                list2.add(newInt);
            }
            Collections.sort(list2);
            Integer2 target = list.get(M);
            for(int j = 0; j<N; j++){
                if(list2.get(j).equals(target)){
                    System.out.println(j+1);
                }
            }
        }
        
    }
}


class Integer2 implements Comparable<Integer2>{
    
    int value;
    int count = 1;
    static List<Integer> values = new ArrayList<>();
    
    Integer2(int v){
        this.value = v;
        int counter = 1;
        for(int i : values){
            if(i == v)
                counter++;
        } 
        this.count = counter;
        values.add(v);
    }
    
    
    @Override
    public int compareTo(Integer2 i){
        if(this.value == i.value){
            return this.count - i.count;
        }
        return this.value - i.value;
    }
    
}
