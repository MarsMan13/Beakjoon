import java.util.*;
import java.io.*;


class Main{

    static int N, C;    // villages, max of truck
    static int M;       // mails
    static List<Mail> input = new ArrayList<>();
    static int[] minor = null;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(bf.readLine());

        minor = new int[N+1];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            input.add(new Mail(from, to, size));
        }
        Collections.sort(input);

        // END OF INIT

        int result = 0;
        int[] rest = new int[N+1];
        for(int i = 0; i<N; i++)
            rest[i] = C;
        for(Mail m : input){
            int from = m.from;
            int to = m.to;

            int min = rest[from];
            for(int i = from; i< to; i++){
                if(rest[i] < min){
                    min = rest[i];
                }
            }

            int minor = m.size;
            if(min < m.size)
                minor = min;

            for(int i = from; i<to; i++){
                rest[i] -= minor;
            }
            result += minor;
        } 

        System.out.println(result);
    }
}

class Mail implements Comparable<Mail>{

    int from, to;
    int size;

    Mail(int from, int to, int size){
        this.from = from;
        this.to = to;
        this.size = size;
    }

    @Override
    public int compareTo(Mail m){
        if(this.to != m.to){
            return this.to - m.to;
        }
        return this.from - m.from;
    }

    @Override
    public String toString(){
        return "from: "+this.from+" to: "+this.to +" size: "+this.size;
    }
}

