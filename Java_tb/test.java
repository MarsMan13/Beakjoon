import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 암기왕
 * https://www.acmicpc.net/problem/2776
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 개수
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int min = arr[0];
            int max = arr[arr.length - 1];
            int mid = (min + max) / 2;
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(binarysearch(min, max, mid, x)+"\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static int binarysearch(int min, int max, int mid, int x) {
        while (min <= max) {
            mid = (min + max) / 2;
            if (x > mid) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
            if (min == x) {
                return 1;
            }
        }
        return 0;
    }
}
