import java.util.*;
import java.io.*;


class Main{
    
    static TreeMap<Integer, Integer> dp = null;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
       
        int P = Integer.parseInt(st.nextToken());
        while(P-- != 0){
            dp = new TreeMap<>();
            dp.put(1, 1); dp.put(2, 1);
            st = new StringTokenizer(bf.readLine());
            int C = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
        
            int i = 1;
            while(true){
                if(def1(i+1, M)%M == 1 && def1(i+2, M)%M == 1){
                    sb.append(C);
                    sb.append(" ");
                    sb.append(i);
                    sb.append("\n");
                    break;
                }
                i++;
            } 
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    public static int def1(int i, int M){
    
        if(!dp.containsKey(i)){
            dp.put(i, (def1(i-1, M) + def1(i-2, M))%M);
        }
        return dp.get(i);    
    }
}