import java.util.*;
import java.io.*;


class Main{
    
    static int N;
    static int[] inputs = null;
    static int M;
    static int[][] mem = null;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        inputs = new int[N+1];
        mem = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(i == j){
                    mem[i][j] = 1;
                }
                mem[i][j] = -1;
            }
        }
        
        st = new StringTokenizer(bf.readLine());
        for(int i = 1; i<=N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        // END OF INIT
        
        // END OF PROCESS
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int toto = Integer.parseInt(st.nextToken());
        
            sb.append(def1(from, toto));
            sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    public static int def1(int start, int end){
        if(mem[start][end] != -1){
            return mem[start][end];
        }
        int ret = 1;
        if(start < end){
            if(inputs[start] == inputs[end]){
                ret = def1(start+1, end-1); 
            }
            else{
                ret = 0;
            }
        }
        return mem[start][end] = ret;
    }
}

