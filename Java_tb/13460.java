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
        
        bfs();
        
        
    }
    
    static int[] xx = {1, -1, 0, 0};
    static int[] yy = {0, 0, 1, -1};
   
    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(Rrow, Rcol, Brow, Bcol, 0));
        while(!(queue.isEmpty())){
            Node temp = queue.poll();
            System.out.println(temp);
            for(int k = 0; k < 4; k++){
                int redCursor_i = temp.i; int redCursor_j = temp.j;
                int blueCursor_i = temp.ii; int blueCursor_j = temp.jj;
                
                if(k == 0){        //x +
                    if(redCursor_j < blueCursor_j){
                        while(blueCursor_j+xx[k] != 0 && blueCursor_j+xx[k] != redCursor_j){
                            blueCursor_j += xx[k];
                        }
                        while(redCursor_j+xx[k] !=0 && redCursor_j+xx[k] != blueCursor_j){
                            redCursor_j += xx[k];
                        }
                    }
                    else{
                        while(redCursor_j+xx[k] !=0 && redCursor_j+xx[k] != blueCursor_j){
                            redCursor_j += xx[k];
                        }
                        while(blueCursor_j+xx[k] != 0 && blueCursor_j+xx[k] != redCursor_j){
                            blueCursor_j += xx[k];
                        }
                    }
                }
                else if(k == 1){    //x -
                    if(redCursor_j < blueCursor_j){
                        while(redCursor_j+xx[k] !=0 && redCursor_j+xx[k] != blueCursor_j){
                            redCursor_j += xx[k];
                        }
                        while(blueCursor_j+xx[k] != 0 && blueCursor_j+xx[k] != redCursor_j){
                            blueCursor_j += xx[k];
                        }
                    }
                    else{
                        while(blueCursor_j+xx[k] != 0 && blueCursor_j+xx[k] != redCursor_j){
                            blueCursor_j += xx[k];
                        }
                        while(redCursor_j+xx[k] !=0 && redCursor_j+xx[k] != blueCursor_j){
                            redCursor_j += xx[k];
                        }
                    }
                }
                else if(k == 2){    //y +
                    if(redCursor_i < blueCursor_i){
                        while(blueCursor_i+yy[k] != 0 && blueCursor_i+yy[k] != redCursor_i){
                            blueCursor_i += yy[k];
                        }
                        while(redCursor_i+yy[k] !=0 && redCursor_i+yy[k] != blueCursor_i){
                            redCursor_i += yy[k];
                        }
                    }
                    else{
                        while(redCursor_i+yy[k] !=0 && redCursor_i+yy[k] != blueCursor_i){
                            redCursor_i += yy[k];
                        }
                        while(blueCursor_i+yy[k] != 0 && blueCursor_i+yy[k] != redCursor_i){
                            blueCursor_i += yy[k];
                        }
                    }

                }
                else if(k == 3){    //y -
                    if(redCursor_i < blueCursor_i){
                        while(redCursor_i+yy[k] !=0 && redCursor_i+yy[k] != blueCursor_i){
                            redCursor_i += yy[k];
                        }
                        while(blueCursor_i+yy[k] != 0 && blueCursor_i+yy[k] != redCursor_i){
                            blueCursor_i += yy[k];
                        }
                    }
                    else{
                        while(blueCursor_i+yy[k] != 0 && blueCursor_i+yy[k] != redCursor_i){
                            blueCursor_i += yy[k];
                        }
                        while(redCursor_i+yy[k] !=0 && redCursor_i+yy[k] != blueCursor_i){
                            redCursor_i += yy[k];
                        }
                    }

                }
                if(temp.count+1 < 10)
                    queue.add(new Node(redCursor_i, redCursor_j, blueCursor_i, blueCursor_j, temp.count+1));
            }
        }
        
    }
}

class Node{
    int count = 0;    //for step memory
    int from;
    
    int i, j;        //about red ball
    int ii, jj;      //about blue ball
    
    Node(int i, int j, int ii, int jj, int count){

        this.i = i; this.j = j;        //init red ball
        this.ii = ii; this.jj = jj;    //init blue ball
        this.count = count;
    }
    
    public void go(int xx, int yy, int[][] board){
        
        for(int k = 0; k<4; k++){
        }
    }
    
    public String toString(){
        return "i: "+i+" j: "+j+", count: "+count;
    }
    
}













