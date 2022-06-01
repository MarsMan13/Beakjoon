import java.util.*;
import java.io.*;


class Main{

    static String input = null;
    static TreeMap<Integer, Bracket> brackets = new TreeMap<>();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = bf.readLine();
        {
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i<input.length(); i++){
                if(input.charAt(i) == '(')
                    stack.push(i);
                else if(input.charAt(i) == ')'){
                    int index_ = stack.pop();
                    brackets.put(index_, new Bracket(index_, i));
                }
            }
        }
        recursiveFunc(0, new StringBuilder(), new ArrayDeque<>(), 0);
        System.out.println(answer);        
    }

    public static void showExpression(Deque<Bracket> stack){
        int[] shownBracket = new int[input.length()];
        for(Bracket b : stack){
            shownBracket[b.head] = 1;
            shownBracket[b.tail] = 1;
        }
        //
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) == '(' || input.charAt(i) == ')'){
                if(shownBracket[i] == 1)
                    answer.append(input.charAt(i));    
            }
            else
                answer.append(input.charAt(i));
        }
        answer.append("\n");
    }

    public static void recursiveFunc(int index, StringBuilder sb, Deque<Bracket> stack, int flag){
        if(index == input.length()){
            if(flag != 0)
                showExpression(stack);
            return;
        }
        if(input.charAt(index) == '('){
            Bracket curBracket = brackets.get(index);
            Bracket beforeBracket = curBracket.beforeBracket;
            if(beforeBracket == null ||
                !((Bracket.nextBracketChecker(curBracket, beforeBracket)) && (!stack.contains(beforeBracket)))
            )
                stack.push(brackets.get(index));  // put '('
                recursiveFunc(index+1, sb, stack, flag);
                stack.pop();
            //*********************************** */
            recursiveFunc(index+1, sb, stack, flag+1);
        }
        else
            recursiveFunc(index+1, sb, stack, flag);
    }
}


class Bracket{

    static Bracket curBracket = null;

    int head, tail;
    Bracket beforeBracket = null;
    int selected = 0;
    Bracket(int head, int tail){
        this.head = head; this.tail = tail;
        beforeBracket = curBracket;
        curBracket = this;
    }

    public static boolean nextBracketChecker(Bracket p1, Bracket p2){
        return ((p1.head - p2.head) * (p1.tail - p2.tail)) == 1;
    }

    @Override
    public String toString(){
        return "[ "+this.head+" - "+this.tail+" ]";
    }
}