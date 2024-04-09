package 백준.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int[] a;
    public static boolean[] visited;
    public static List<Integer> answer;
    public static int sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = new int[9];
        visited = new boolean[9];
        answer = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }

        Arrays.sort(a);
        combination(a, visited, 0, 9, 2);

        for (int i = 0; i < 9; i++) {
            if (answer.contains(i)) {
                continue;
            }

            System.out.println(a[i]);
        }
    }

    public static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {

            int value = sum;
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    value -= a[i];
                    list.add(i);
                }
            }

            if (value == 100) {
                answer = list;
            }

            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
