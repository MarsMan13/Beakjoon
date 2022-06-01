import java.util.*;
import java.io.*;


class Main{

    static String input = null;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = bf.readLine();
        recursiveFunc(0, new StringBuilder(), new ArrayDeque<>(), 0);
        System.out.println(answer);        
    }

    public static void recursiveFunc(int index, StringBuilder sb, Deque<Integer> stack, int flag){
        if(index == input.length()){
            if(flag != 0){
                answer.append(sb);
                answer.append("\n");
            }
            return;
        }

        // **************************************
       
        // System.out.println(""+index+" : "+input.charAt(index));
        // System.out.println(stack);
        // System.out.println("--------------------------------");
        if(input.charAt(index) == '('){
            stack.push(index);  // put '('
            sb.append(input.charAt(index));
            recursiveFunc(index+1, sb, stack, flag);
            stack.pop();
            sb.deleteCharAt(sb.length()-1);
            //*********************************** */
            stack.push(-index); // put ')'
            recursiveFunc(index+1, sb, stack, flag+1);
            stack.pop();
        }
        else if(input.charAt(index) == ')'){
            int popped = stack.pop();
            if(popped >= 1)
                sb.append(input.charAt(index));
            recursiveFunc(index+1, sb, stack, flag);
            if(popped >= 1)
                sb.deleteCharAt(sb.length()-1);
            stack.push(popped);
        }
        else{ // Number and Operators
            sb.append(input.charAt(index));
            recursiveFunc(index+1, sb, stack, flag);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}