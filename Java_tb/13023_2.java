import java.util.*;
import java.io.*;

class Main{

    static int N, M;
    static ArrayList<Integer>[] friends = null;
    static int[] visited = null;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());   M = Integer.parseInt(st.nextToken());
        visited = new int[N];
        friends = new ArrayList[N];
        for(int i = 0; i<N; i++)    friends[i] = new ArrayList<Integer>();
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            friends[f1].add(f2);
            friends[f2].add(f1);
        }
        // END OF INIT
        int ret = 0;
        for(int i = 0; i<N; i++){
            visited[i] = 1;
            ret = dfs(i, 0);
            if(ret == 1)    break;
            visited[i] = 0;
        }
        System.out.println(ret);
    }

    public static int dfs(int index, int steps){
        if(steps == 4)
            return 1;
        int ret = 0;
        for(int addj : friends[index]){
            if(visited[addj] == 0){
                visited[addj] = 1;
                ret = dfs(addj, steps+1);
                if(ret == 1)    return 1;
                visited[addj] = 0;
            }
        }
        return 0;
    }
}