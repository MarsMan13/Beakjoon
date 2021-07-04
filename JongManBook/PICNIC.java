import java.util.*;
import java.io.*;


class Main{
   
    static int[][] pairs = null; 
    
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t<T; t++){
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());  
            int m = Integer.parseInt(st.nextToken());
            //
            pairs = new int[n][n];
            st = new StringTokenizer(bf.readLine());
            for(int i = 0; i<m; i++){
                int p1 = Integer.parseInt(st.nextToken());  int p2 = Integer.parseInt(st.nextToken());
                pairs[p1][p2] = pairs[p2][p1] = 1;
            }
            // END OF INIT
        
            int[] visited = new int[n];
        
            sb.append(def(visited, n));    sb.append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());    bw.flush(); bw.close();
    }
    
    public static int def(int[] visited, int n){
        int target = -1;
        for(int i = 0; i<n; i++){
            if(visited[i] == 0){
                target = i;
                break;
            }
        }
        if(target == -1)    return 1;   // 0? 1?
        //
        visited[target] = 1;
        int count = 0;
        for(int j = 0; j<n; j++){
            if(visited[j] == 1 || target == j || pairs[target][j] == 0)  continue;
            // if target and j is friend, then
            visited[j] = 1;
            count += def(visited, n);
            visited[j] = 0;
        }
        visited[target] = 0;
        return count;
    }
}