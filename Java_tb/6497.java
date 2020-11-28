import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.StringTokenizer;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Main{
    
	static ArrayList<Edge> edges = null;
    static int[] parents = null;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int sum2 = 0;
		int sum = 0;

        while(true){
           
            sum2 = 0;
            sum = 0;

            st = new StringTokenizer(bf.readLine());
       
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
       
            if(m == 0 && n == 0){
                break;
            }
            
            edges = new ArrayList<>();
            parents = new int[m+1];
            for(int i = 0; i<=m; i++)
                parents[i] = i;

            int temp1 = 0;
            int temp2 = 0;
            int temp3 = 0;
            for(int i = 0; i<n; i++){
                st = new StringTokenizer(bf.readLine());
                temp1 = Integer.parseInt(st.nextToken());
                temp2 = Integer.parseInt(st.nextToken());
                temp3 = Integer.parseInt(st.nextToken());
                edges.add(new Edge(temp1, temp2, temp3));
                sum2 += temp3;
            }

            Collections.sort(edges);

            int count = 0;
            for(int i = 0; i<n; i++){

                Edge tempEdge = edges.get(i);
                int tempLeft = tempEdge.left;
                int tempRight = tempEdge.right;

                if(getParent(tempLeft) != getParent(tempRight)){
                    sum += tempEdge.meter;
                    union(tempLeft, tempRight);
                    count++;
                }
                if(count == m-1)
                    break;
            }
			bw.write((sum2 - sum) + "\n");
        }
		bw.flush();
		bw.close();
		bf.close();

    }

    static int getParent(int index){
        if(parents[index] == index)
            return index;
        return parents[index] = getParent(parents[index]);
    }

    static int union(int a, int b){
        int p1 = getParent(a);
        int p2 = getParent(b);

        parents[p1] = p2;
		return 0;
    }

}

class Edge implements Comparable<Edge>{

    int left;
    int right;
    int meter;

    Edge(int left, int right, int meter){
        this.left = left;
        this.right = right;
        this.meter = meter;
    }

    @Override
    public int compareTo(Edge target){
        return this.meter - target.meter;
    }

}

