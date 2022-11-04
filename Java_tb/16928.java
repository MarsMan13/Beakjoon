import java.util.*;
import java.io.*;

class Main{

    static final int SIZE = 10;
    static int N, M;
    static int[] sadaris = new int[101];
    static int[] snakes = new int[101];
    static int[] mem = new int[101];
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sadaris[from] = to;
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            snakes[from] = to;
        }
        Arrays.fill(mem, -1);   mem[1] = 0;
        // END OF INIT
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, 0));
        while(!queue.isEmpty()){
            Pair curPair = queue.poll();
            if(curPair.left == 100){
                System.out.println(curPair.right);
                break;
            }
            if(mem[curPair.left] == -1) mem[curPair.left] = curPair.right;
            for(int i = 1; i<=6; i++){
                int nextPos = curPair.left + i;
                if(nextPos <= 100){
                    if(sadaris[nextPos] != 0)   nextPos = sadaris[nextPos];
                    if(snakes[nextPos] != 0)    nextPos = snakes[nextPos];
                }
                if(nextPos <= 100 &&  mem[nextPos] == -1)
                    queue.offer(new Pair(nextPos, curPair.right+1));
            }
        }
    } 
}

class Pair{
    int left, right;
    Pair(int left, int right){
        this.left = left;
        this.right = right;
    }
}