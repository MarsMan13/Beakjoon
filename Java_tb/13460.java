import java.util.*;
import java.io.*;


class Main{
    
    static int N, M;
    
    static int Rrow, Rcol;
    static int Brow, Bcol;
    
    static int[][] board = null;
    
    static int result = -1;
    
    public static void main(String[] args) throws IOException {

       
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
           
        board = new int[N][M];
        
        // END OF INIT
       
        for(int i = 0; i<N; i++){
            String row = bf.readLine();
            for(int j = 0; j<M; j++){
                char tempAt = row.charAt(j);
                board[i][j] = 1;            // road
                switch(tempAt){
                    case '#':    // 0
                        board[i][j] = 0;    // barier
                        break;
                    case 'R':
                        Rrow = i; Rcol = j;
                        break;
                    case 'B':
                        Brow = i; Bcol = j;
                        break;
                    case 'O':
                        board[i][j] = 2;    // hole
                        break;
                }
            }
        }
       
        // END OF INIT
        
        
    }
    
    static int[] xx = {1, -1, 0, 0};
    static int[] yy = {0, 0, 1, -1};
    
    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        
        while(!(queue.isEmpty())){
            Node temp = queue.poll();
           
            for(int i = 0; i<4; i++){
                
            }
        }
        
    }
}

class Node{
    int i, j;
    int from;
    
    Node(int i, int j){
        this.i = i;
        this.j = j;
    }
    
}
