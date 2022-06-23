import java.util.*;
import java.io.*;


class Main{

    static int L, C;
    static char[] inputs = null;
    static int[] vowels = null;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());   C = Integer.parseInt(st.nextToken());
        inputs = new char[C];
        vowels = new int[C];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<C; i++){
            inputs[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(inputs);
        for(int i = 0; i<C; i++){
            if(inputs[i] == 'a' || inputs[i] == 'e' || inputs[i] == 'i' || inputs[i] == 'o' || inputs[i] == 'u')
                vowels[i] = 1;
            else
                vowels[i] = 0;
        }
        recursive(0, new StringBuilder(), 0, 0, 0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    public static void recursive(int index, StringBuilder tempSb, int length, int vowelsCount, int consonantsCount){
        if(index == C){
            if(vowelsCount >= 1 && consonantsCount >= 2 && length == L){
                sb.append(tempSb);  sb.append("\n");
            }
            return;
        }
        // SELECTED
        if(length < L){
            recursive(
                index+1, tempSb.append(inputs[index]), length+1,
                vowelsCount + (vowels[index] == 1 ? 1 : 0), consonantsCount + (vowels[index] == 0 ? 1 : 0)
            );
            tempSb.deleteCharAt(tempSb.length()-1);
        }
        // NOT SELECTED
        recursive(index+1, tempSb, length, vowelsCount, consonantsCount);
    }
}