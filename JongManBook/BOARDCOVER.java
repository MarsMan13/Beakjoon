import java.util.*;
import java.io.*;


class Main{

    static final char BLACK = '#';
    static final char WHITE = '.';
    
    static int[][] map = null;
    static int H, W;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t<T; t++){
            st = new StringTokenizer(bf.readLine());
            H = Integer.parseInt(st.nextToken());   W = Integer.parseInt(st.nextToken());
            
            map = new int[H+2][W+2];
            for(int i = 0; i<H+2; i++)  map[i][0] = map[i][W+1] = BLACK;
            for(int j = 0; j<W+2; j++)  map[0][j] = map[H+1][j] = BLACK;
            
            int rest = 0;
            for(int h = 1; h<=H; h++){
                String line = bf.readLine();
                for(int w = 1; w<=W; w++){
                    map[h][w] = line.charAt(w-1);
                    if(map[h][w] == WHITE)  rest++;
                }
            }
            // END OF INIT
            sb.append(def(rest));   sb.append("\n"); 
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());    bw.flush(); bw.close();
    }
    
    static int def(int rest){
        if(rest == 0)
            return 1;
        
        int count = 0;
        loop:
        for(int i = 1; i<=H; i++){
            for(int j = 1; j<=W; j++){
                if(map[i][j] == BLACK)  continue;
                
                for(int k = 0; k<ii.length; k++){
                    int e1_i = i + ii[k][0];  int e1_j = j + jj[k][0];
                    int e2_i = i + ii[k][1];  int e2_j = j + jj[k][1];
                    if(map[i][j] == WHITE && map[e1_i][e1_j] == WHITE && map[e2_i][e2_j] == WHITE){
                        map[i][j] = map[e1_i][e1_j] = map[e2_i][e2_j] = BLACK;
                        count += def(rest-3);
                        map[i][j] = map[e1_i][e1_j] = map[e2_i][e2_j] = WHITE;
                    }
                }
                break loop;
            }
        }
        return count; 
    }
    
    static int[][] ii = new int[][]{{1, 0}, {0, 1}, {1, 1}, {1, 1}};
    static int[][] jj = new int[][]{{0, 1}, {1, 1}, {-1, 0}, {0, 1}};
}