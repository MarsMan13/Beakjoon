import java.util.*;
import java.io.*;


class Main{

    static int N;
    static int[] switchs = null;
    static int[] bulbs = null;
    static List<TreeSet<Integer>> checker = null;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        switchs = new int[N+1];
        bulbs = new int[N+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 1; i<=N; i++){
            switchs[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i = 1; i<=N; i++){
            bulbs[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=N; i++){

        }

        // END OF INIT

        TreeSet<Integer> choices = new TreeSet<>();

    }

    static void def1(TreeSet<Integer> choices, int index){
       
        TreeSet<Integer> temp1 = new TreeSet<Integer>();
        TreeSet<Integer> temp2 = new TreeSet<Integer>();
        temp1.addAll(choices);
        TreeSet<Integer> temp2 = null;
        if(index+1 <= N){
            temp1.addAll(choices);
            def1(temp1, index+1);
            temp2.addAll(choices);
            for(Integer i : temp2)
            def2(temp2, index+1);
        }

    }
}

class Line{
    int switchPos;
    int bulbPos;

    Line(int switchPos, int bulbPos){
        this.switchPos = switchPos;
        this.bulbPos = bulbPos;
    }
}