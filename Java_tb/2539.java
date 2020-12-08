import java.util.*;
import java.io.*;


class Main{

    static int row, col;
    static int need;
    static int N;
    static List<Point> input = new ArrayList<>();
    static List<Line> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        need = Integer.parseInt(bf.readLine());
        N = Integer.parseInt(bf.readLine());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            input.add(
                new Point(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
                )
            );
        }
        Collections.sort(input);
        for(int i = 0; i<N-1; i++){
            Point p1 = input.get(i);
            Point p2 = input.get(i+1);
            lines.add(new Line(p1, p2)); 
        }
    }
}

class Line {
    Point p1, p2;
    int length;

    Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
        this.length = Math.abs(p1.x - p2.x);
    }
}

class Point implements Comparable<Point>{

    static int highest = 0;
    int y, x;

    Point(int x, int y){
        this.y = y;
        this.x = x;
        if(highest < this.y)
            highest = this.y;
    }

    @Override
    public int compareTo(Point p){
        return this.x - p.x;
    }
}