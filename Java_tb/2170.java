import java.util.*;
import java.io.*;


class Main{

    static int N;
    static List<Point> inputs = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            Point p = new Point(
                    Integer.parseInt(st.nextToken()), 
                    Integer.parseInt(st.nextToken())
                );
            inputs.add(p);
        }
        Collections.sort(inputs);
        // END OF INIT
        long result = 0L;
        int bound = inputs.get(0).x;
        for(Point p : inputs){
            if(p.y <= bound)
                continue;
            result += (p.y - (bound < p.x ? p.x : bound));
            bound = p.y; 
        }
        System.out.println(result);
    }
}

class Point implements Comparable<Point>{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o){
        if(this.x != o.x)
            return this.x - o.x;
        return this.y - o.y;
    }
}