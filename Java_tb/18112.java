import java.util.*;
import java.io.*;


class Main{

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String from_ = bf.readLine();
        String to_ = bf.readLine();
        int from__ = Integer.parseInt(from_, 2);
        int to__ = Integer.parseInt(to_, 2);
        
        Binary from = new Binary(from__);

        int[] visited = new int[10000];
        Queue<Binary> queue = new LinkedList<>();
        queue.offer(from);
        visited[from__] = 1;
        while(!queue.isEmpty()){
            Binary cur = queue.poll();
            if(cur.value == to__){
                System.out.println(cur.time);
                return;
            }
            // Comp1
            for(Binary b : cur.getComps()){
                if(visited[b.value] == 0){
                    visited[b.value] = 1;
                    b.time = cur.time+1;
                    queue.offer(b); 
                }
            }
            // Add
            if(visited[cur.value+1] == 0 && cur.value + 1 < 1024){
                visited[cur.value+1] = 1;
                Binary newBin = new Binary(cur.value+1);
                newBin.time = cur.time + 1;
                queue.offer(newBin);
            }
            // Sub
            if(cur.value > 0 && visited[cur.value-1] == 0){
                visited[cur.value-1] = 1;
                Binary newBin = new Binary(cur.value-1);
                newBin.time = cur.time + 1;
                queue.offer(newBin);
            }
        }
    }
}

class Binary{
    static int[] pows = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};

    int value;
    int time = 0;
    Binary(int value){this.value = value;}

    byte[] getBinary(){
        if(value == 0)  return new byte[1];
        int i = 0;
        for(; pows[i] <= value; i++){
            //System.out.println(pows[i] + " " + value);
        }
        byte[] binary = new byte[i+1];
        int value_ = value;
        for(; 0<=i; i--){
            binary[i] = (byte)(value_ / pows[i]);
            value_ = (value_ % pows[i]);
        }
        return binary;
    }

    Binary[] getComps(){
        if(value == 0)  return new Binary[]{new Binary(0)};

        byte[] binary = getBinary();
        Binary[] ret = new Binary[binary.length-2];
        for(int i = 0; i<binary.length-2; i++){
            binary[i] = (binary[i] == 0) ? (byte)1 : (byte)0;
            ret[i] = new Binary(Binary.getValue(binary));
            binary[i] = (binary[i] == 0) ? (byte)1 : (byte)0;
        }
        return ret;
    }

    static int getValue(byte[] binary){
        int value = 0;
        for(int i = 0; i<binary.length; i++){
            value += pows[i] * binary[i];
        }
        return value;
    }

    @Override
    public String toString(){
        byte[] binary = getBinary();
        String str = "";
        for(int i = 0; i<binary.length; i++)
            str += binary[i];
        return str;
    }
}
