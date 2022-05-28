import java.util.*;
import java.io.*;


class Main{

    static int N;
    static int[] input = null;
    static List<HashMap<Integer, Long>> list = null; // <step, sum>

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        input = new int[N];
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
            list.add(i, new HashMap<>());
        }

        for(int i = N-1; 0<=i; i--){
            int current = input[i];
            for(int j = i+1; j<N; j++){
                int step = input[j] - current;
                if(list.get(j).containsKey(step)){
                    list.get(i).put(step, Math.abs(list.get(j).get(step))+current);
                }
                else{
                    list.get(i).put(step, -1L * (current + input[j]));
                }
            }
        }

        Long max = 0L;

        for(int i = 0; i<N; i++){
            // System.out.println("i: "+i);
            // System.out.println(list.get(i));
            // System.out.println();
            List<Long> l = new ArrayList<Long>(list.get(i).values());
            for(Long e : l){
                if(max < e){
                    max = e;
                }
            }
        }

        System.out.println(max);

    }
}
