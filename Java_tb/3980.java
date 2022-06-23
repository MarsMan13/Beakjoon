import java.util.*;
import java.io.*;


class Main{

    static int[][] ability = null;
    static int answer = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t<T; t++){
            ability = new int[11+1][11+1];
            answer = -1; 
            for(int i = 1; i<=11; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j = 1; j<=11; j++){
                    ability[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            def(1, new int[11+1]);
            System.out.println(answer);
        }
    }

    public static void def(int index, int[] positions){
        if(index == 11+1){
            int tot = 0;
            for(int i = 1; i<=11; i++){
                tot += ability[positions[i]][i];
            }
            if(answer == -1 || answer < tot)
                answer = tot;
            return;
        }

        for(int i = 1; i<=11; i++){
            if(ability[index][i] == 0 || positions[i] != 0)   continue;
            positions[i] = index;
            def(index+1, positions);
            positions[i] = 0;
        }
    }
}