import java.util.*;
import java.io.*;


class Main{

    static int N = 0;
    static List<Line> horizon = new ArrayList<>();
    static List<Line> vertical = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            
            if(i % 2 == 0){ //vertical
                vertical.add(new Line(2, col, row));
            }
            else{           //horizon
                horizon.add(new Line(1, col, row));
            }
        }
    }
}


class Line{
    int flag = 0;   // 1 --> horizon, 2 --> vertical
    int col, row;

    Line(int flag, int col, int row){
        this.flag = flag;
        this.col = col;
        this.row = row;
    }

}