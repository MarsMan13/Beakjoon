import java.util.*;
import java.io.*;


class Main{

    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());   m = Integer.parseInt(st.nextToken());
        Member.members = new Member[n+1];
        st = new StringTokenizer(bf.readLine());
        st.nextToken();
        for(int i = 2; i<=n; i++){
            Member.members[i] = new Member();
            Member.setBoss(i, Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int compTo = Integer.parseInt(st.nextToken());
            int compScale = Integer.parseInt(st.nextToken());
            Member.members[compTo].compTot += compScale;
        }
        propagationComp(Member.members[1]);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=n; i++){
            sb.append(Member.members[i].compTot);
            sb.append(" ");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    static void propagationComp(Member boss){
        for(Member m : boss.juniors){
            m.compTot += boss.compTot;
            propagationComp(m);
        }
    }
}

class Member {
    static Member[] members = null;

    List<Member> juniors = new ArrayList<>();
    int compTot = 0;
    Member(){ }

    static void setBoss(int target, int boss){
        if(members[target] == null) members[target] = new Member();
        if(members[boss] == null)   members[boss] = new Member();
        members[boss].juniors.add(members[target]);
    }

}