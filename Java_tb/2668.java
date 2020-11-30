import java.util.*;
import java.io.*;


class Main{

    static int N = 0;
    static int[] input = null;
    static Node[] nodes = null;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        input = new int[N+1];
        nodes = new Node[N+1];

        for(int i = 1; i<=N; i++){
            input[i] = Integer.parseInt(bf.readLine());
        }
        
        // END OF INIT

        for(int i = 1; i<=N; i++){
            if(nodes[i] == null){
                nodes[i] = new Node(i);
                nodes[i].connectNext(input[i]);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(Iterator<Integer> itr = result.iterator(); itr.hasNext(); ){
            System.out.println(itr.next());
        }
    }

}


class Node{
    static int chainNum = 0;

    // chain
    int thisChainNum;
    
    // contents
    int index;
    
    // conclusion
    int ox = 0;

    Node(int index){
        this.index = index;
        this.thisChainNum = chainNum++;
    }

    Node(int index, int chainNum){
        this.index = index;
        this.thisChainNum = chainNum;
    }

    public int connectNext(int nextIndex){
        Node[] nodes = Main.nodes;
        int[] input = Main.input;
        List<Integer> result = Main.result; 

        int temp = 0;
        if(nodes[nextIndex] == null){
            nodes[nextIndex] = new Node(nextIndex, this.thisChainNum);
            temp = nodes[nextIndex].connectNext(input[nextIndex]);
            if(temp == 2){
                return this.ox = 2;
            }
            if(temp < 0){
                result.add(this.index);
                this.ox = 1;            
                if(temp * -1 == this.index){
                    return 2;
                }
                return temp;
            }
        }
        else{
            if(nodes[nextIndex].thisChainNum == this.thisChainNum){
                result.add(this.index); 
                this.ox = 1;
                if(nodes[nextIndex] == this)
                    return 2;
                return nextIndex * -1;
            }
        } 
        return this.ox = 2;
    }
}
