import java.util.*;
import java.io.*;


class Main{

    static int N = 0;
    static int[] input = null;
    static int maximum = 0;
    static List<Range> range = new ArrayList<>();
    static int[][] dp = null;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(bf.readLine());
        input = new int[N];
        dp = new int[3][N]; 
        for(int i = 0; i<3; i++){
            for(int j = 0; j<N; j++)
                dp[i][j] = -1;
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        maximum = Integer.parseInt(bf.readLine());

        int sumTemp = 0;
        for(int i = 0; i<maximum-1; i++){
            sumTemp += input[i];
        }

        for(int i = 0; i<N-maximum+1; i++){
            sumTemp += input[i+maximum-1];
            range.add(new Range(i, i+maximum-1, sumTemp));
            sumTemp -= input[i];
        }


        // END OF INIT

        // Collections.sort(range, Collections.reverseOrder());

        System.out.println(def1(0, 0));
        
    }

    static int def1(int step, int index){
        if(step == 3 || range.size() <= index)   return 0;
        if(dp[step][index] != -1)
            return dp[step][index];
        int left = def1(step+1, index+maximum) + range.get(index).sum;
        int right = def1(step, index+1);
        return dp[step][index] = Math.max(left, right);
    }

}

class Range implements Comparable<Range>{
    int from, to;
    int sum;

    Range(int from, int to, int sum){
        this.from = from;
        this.to = to;
        this.sum = sum;
    }

    @Override
    public int compareTo(Range o){
        return this.sum - o.sum;
    }

    @Override
    public String toString(){
        return "from: "+this.from + ", to: "+this.to+", sum: "+this.sum;
    }
}