import java.util.*;


class Main{

    static int A;
    static int B;
    static TreeMap<Integer, Integer> aa = new TreeMap<>();
    static TreeMap<Integer, Integer> bb = new TreeMap<>();
    static HashSet<Integer> element = new HashSet<>();
    static List<Integer> eleList = null;

    static int min = -1;
    static int[] result = new int[]{1, 1};  // GCM, LCM
    static int[] result2 = new int[2];

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        {
            int tempA = A;
            for(int i = 2; i<=tempA; i++){
                while(true){
                    if(tempA % i == 0){
                        if(!aa.containsKey(i)){
                            aa.put(i, 0);
                        }
                        aa.replace(i, aa.get(i)+1);
                        element.add(i);
                        tempA /= i;
                    }
                    else{
                        break;
                    }
                }
            }
            int tempB = B;
            for(int i = 2; i<=tempB; i++){
                while(true){
                    if(tempB % i == 0){
                        if(!bb.containsKey(i)){
                            bb.put(i, 0);
                        }
                        bb.replace(i, bb.get(i)+1);
                        element.add(i);
                        tempB /= i;
                    }
                    else{
                        break;
                    }
                }
            }
        }

        eleList = new ArrayList<>(element);
        if(!eleList.isEmpty()){
            def1(0);
        }
        Arrays.sort(result2);
        System.out.println(result2[0]+ " "+result2[1]);
    }

    static void def1(int index){
        if(eleList.size() == index){
            if(min == -1 || result[0] + result[1] < min){
                min = result[0] + result[1];
                result2[0] = result[0];
                result2[1] = result[1];
            }
            return;
        }
        int mit = eleList.get(index);
        int seed1 = 1;
        if(aa.containsKey(mit)){
            seed1 *= Math.pow(mit, aa.get(mit));
        }
        int seed2 = 1;
        if(bb.containsKey(mit)){
            seed2 *= Math.pow(mit, bb.get(mit));
        }

        result[0] *= seed1;
        result[1] *= seed2;
        def1(index+1);
        result[0] /= seed1;
        result[1] /= seed2;
        result[0] *= seed2;
        result[1] *= seed1;
        def1(index+1);
        result[0] /= seed2;
        result[1] /= seed1;

    }
}
