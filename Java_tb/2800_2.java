import java.util.*;
import java.io.*;


class Main{


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String exp = bf.readLine(); // indexing by using charAt( )

        // ( ( ( 2 ) ) )
        Deque<Integer> bracketStack = new ArrayDeque<>();
        Deque<Character> resultStack = new ArrayDeque<>();
        def1(bracketStack, resultStack, exp, 0);
    }

    public static void def1(Deque<Integer> bracketStack, Deque<Character> resultStack, String exp, int index){
        if(index == exp.length()){
            showResultStack(resultStack);
            return;
        }
        if(exp.charAt(index) == '('){
            bracketStack.push(1);   // put
            resultStack.push('(');
            def1(bracketStack, resultStack, exp, index+1);
        }
        else if(exp.charAt(index) == ')'){
            
        }
        else if()
    }

    public static void showResultStack(Deque<Character> resultStack){
        for(Iterator<Character> itr = resultStack.iterator(); itr.hasNext(); )
            sb.append(itr.next());
        sb.append("\n");
    }
}

