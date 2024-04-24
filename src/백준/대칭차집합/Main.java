package 백준.대칭차집합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int A, B, res;

    public static int[] aArray;
    public static int[] bArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        res = 0;

        aArray = new int[A];
        bArray = new int[B];

        aArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(aArray);
        Arrays.sort(bArray);

        //이분 탐색(logN)
        int aValue = 0;
        for (int value : aArray) {
            aValue += binarySearch(value, bArray);
        }

        int bValue = 0;
        for (int value : bArray) {
            bValue += binarySearch(value, aArray);
        }

        res = aArray.length - aValue + bArray.length - bValue;
        bw.write(res + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int binarySearch(int value, int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] < value) {
                start = mid + 1;
            } else if (arr[mid] > value) {
                end = mid - 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
