import java.util.*;
import java.io.*;


class Main{

    static int N, C;    // villages, max of truck
    static int M;       // mails
    static List<Mail> input = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(bf.readLine());

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            input.add(new Mail(from, to, size));
        }
        Collections.sort(input);

        // END OF INIT
        int rest = C;
        for(Mail m : input){

        }


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
        if(this.from != m.from){
            return this.from - m.from;
        }
        return this.to - m.to;
    }

    @Override
    public String toString(){
        return "from: "+this.from+" to: "+this.to +" size: "+this.size;
    }
}

