import java.util.*;
import java.io.*;


class Main{

    static int row, col;
    static int need;
    static int N;
    static List<Integer> xx = null;
    static int highest = -1;

    static int min;
    static int max;
    static int result = 10000000;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        need = Integer.parseInt(bf.readLine());
        N = Integer.parseInt(bf.readLine());

        xx = new ArrayList<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int tempY = Integer.parseInt(st.nextToken());
            int tempX = Integer.parseInt(st.nextToken());
            xx.add(tempX);
            if(highest < tempY){
                highest = tempY;
            }
        }

        Collections.sort(xx);

        min = highest;
        max = 1000000;
      
        while(min < max){
            result = (max + min)/2;

            int count = 0;
            int leftPoint = -1;
            for(int i = 0; i<N; i++){
                int tempX = xx.get(i);
                if(leftPoint == -1){
                    leftPoint = tempX;
                    count++;
                }
                if(result < tempX - leftPoint + 1){
                    count++;
                    leftPoint = tempX;
                }
            }
            if(count <= need){
                max = result;
            }
            else{
                min = result+1;
            }
        }
        bw.write(Integer.toString(min));
        bw.flush();
        bf.close();
        bw.close();
    }
}
