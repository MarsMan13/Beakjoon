import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] planes = new int[6];
        for(int i = 0; i<6; i++)
            planes[i] = Integer.parseInt(st.nextToken());
        // END OF INIT
        // About x
        int x = 51;
        for(int i = 0; i<6; i++){
            x = Math.min(x, planes[i]);
        }
        // About y
        int y = 1000;
        y = Math.min(y, planes[0] + planes[1]);
        y = Math.min(y, planes[0] + planes[2]);
        y = Math.min(y, planes[0] + planes[3]);
        y = Math.min(y, planes[0] + planes[4]);
        y = Math.min(y, planes[1] + planes[2]);
        y = Math.min(y, planes[1] + planes[3]);
        y = Math.min(y, planes[1] + planes[5]);
        y = Math.min(y, planes[2] + planes[4]);
        y = Math.min(y, planes[2] + planes[5]);
        y = Math.min(y, planes[3] + planes[4]);
        y = Math.min(y, planes[3] + planes[5]);
        y = Math.min(y, planes[4] + planes[5]);
        // Abouy z
        int z = 1000;
        z = Math.min(z, planes[0] + planes[1] + planes[2]);
        z = Math.min(z, planes[0] + planes[2] + planes[4]);
        z = Math.min(z, planes[0] + planes[3] + planes[4]);
        z = Math.min(z, planes[0] + planes[1] + planes[3]);
        z = Math.min(z, planes[1] + planes[2] + planes[5]);
        z = Math.min(z, planes[1] + planes[3] + planes[5]);
        z = Math.min(z, planes[2] + planes[4] + planes[5]);
        z = Math.min(z, planes[3] + planes[4] + planes[5]);

        // RESULT
        if(N > 1){
            long result = 4 * z + 1L * (N - 1) * 4 * y + 1L * (N - 2) * 4 * y + 1L*(N - 2)*(N - 2)*x + 4L*(N-1)*(N-2)*x;
            System.out.println(result);
        }
        else{
            int maxPlane = 0;
            int planeSum = 0;
            for(int p : planes){
                maxPlane = Math.max(maxPlane, p);
                planeSum += p;
            }
            System.out.println(planeSum - maxPlane);
        }
    }
}
