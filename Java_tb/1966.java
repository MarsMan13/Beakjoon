import java.util.*;
import java.io.*;


class Main{
    
    static int T = 0;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
       
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(bf.readLine());
            List<Page> queue = new LinkedList<>();
            for(int j = 0; j<N; j++){
                int temp = Integer.parseInt(st.nextToken());
                Page newPage = new Page(j, temp);
                queue.add(newPage);
            }
            
            int count = 1;
            while(!(queue.isEmpty())){
                Page firstPage = queue.remove(0);
                int flag = 0;
                for(Page p : queue){
                    if(firstPage.priority < p.priority){
                        flag = 1;
                    }
                } 
                if(flag == 0){
                    if(firstPage.pageNum == M){
                        sb.append(count);
                        sb.append("\n");
                    }
                    count++;
                }
                else{
                    queue.add(firstPage);
                }
            }
        }
        System.out.println(sb.toString());
    }
}


class Page{
    int pageNum;
    int priority;
    Page(int pn, int p){
        this.pageNum = pn;
        this.priority = p;
    }
}