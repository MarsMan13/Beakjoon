import java.util.*;
import java.io.*;

class Main{

    static int N, M;
    static int[] globalVisited = null;
    static int[] visited = null;
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());   M = Integer.parseInt(st.nextToken());
        Person.people = new Person[N];
        globalVisited = new int[N];
        visited = new int[N];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            Person.getInstance(p1).friends.add(Person.getInstance(p2));
            Person.getInstance(p2).friends.add(Person.getInstance(p1));
        }

        for(Person f : Person.people){  
            if(f == null)   continue;
            if(globalVisited[f.id] == 0){
                globalVisited[f.id] = 1;
                visited[f.id] = 1;
                dfs(f.id, 0);
                if(answer == 1) break;
            }
        }
        System.out.println((1 == answer ? 1 : 0));
    }

    public static void dfs(int index, int steps){
        Person curPerson = Person.getInstance(index);
        globalVisited[index] = 1;
        if(4 <= steps)  {
            answer = 1;
            return;
        }
        for(Person f : curPerson.friends){
            if(visited[f.id] == 0){
                visited[f.id] = 1;
                dfs(f.id, steps+1);
                if(answer == 1) return;
                visited[f.id] = 0;
            }
        }
    }
}

class Person{
    static int N;
    static Person[] people = null;
    static int[] visited = null;
    public static Person getInstance(int id){
        if(people[id] == null)
            people[id] = new Person(id);
        return people[id];
    }

    int id;
    List<Person> friends = new ArrayList<>();
    private Person(int id){
        this.id = id;
    }
}