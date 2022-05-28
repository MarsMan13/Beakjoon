import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        MyStack<Node> upper_stack = new MyStack<>();
        MyStack<Node> lower_stack = new MyStack<>();
        List<Node> inputs = new LinkedList<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int x_ = Integer.parseInt(st.nextToken());
            int y_ = Integer.parseInt(st.nextToken());
            Node input = new Node(x_, y_);
            inputs.add(input);
        }
        Collections.sort(inputs); 

        int cur_y = 0;
        for(int i = 0; i<N; i++){
            Node target = inputs.get(i);
            int x_ = target.x; int y_ = target.y;

            if(cur_y <= y_){
                upper_stack.add(new Node(x_, y_));
                cur_y = y_;
                lower_stack = new MyStack<>();
                lower_stack.add(target);
            }
            else{ // in case cur_y > y_
                while(!lower_stack.isEmpty() && lower_stack.get().y <= y_){
                    lower_stack.pop();
                }
                lower_stack.push(target);
                
            }
        }

        //DEBUGGIN PART
        // System.out.println(upper_stack);
        // System.out.println(lower_stack);
        //DEBUGGIN PART

        int answer = 0;
        MyStack<Node> temp_stack = upper_stack;
        for(int i = 0; i<2 ; i++){
            if(!temp_stack.isEmpty()){
                Node target1 = temp_stack.pop();
                while(!temp_stack.isEmpty()){
                    Node target2 = temp_stack.pop();
                    answer += getRectagleSize(target1, target2);
                    target1 = target2;
                }
            }
            temp_stack = lower_stack;           
        }

        System.out.println(answer + cur_y);
    }

    public static int getRectagleSize(Node node1, Node node2){
        
        int width = (node1.x < node2.x) ? (node2.x - node1.x) : (node1.x - node2.x);
        int height = (node1.y < node2.y) ? node1.y : node2.y;
        return width * height;
    }
}

class MyStack<E> extends ArrayDeque<E>{
    public E pop(){
        return this.removeFirst();
    }

    public E get(){
        return this.getFirst();
    }

    public void push(E item){
        this.addFirst(item);
    }
}

class Node implements Comparable<Node>{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int compareTo(Node o){
        return this.x - o.x;
    }

    @Override
    public String toString(){
        return ""+this.x + " " + this.y;
    }
}