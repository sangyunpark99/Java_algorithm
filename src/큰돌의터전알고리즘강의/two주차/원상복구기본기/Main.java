package 큰돌의터전알고리즘강의.two주차.원상복구기본기;

import java.util.Arrays;

public class Main {

    public static String[] alphabet = {"A", "B", "C", "D"};

    public static void main(String[] args) {
        go(new String[3], new boolean[4], 0);
    }

    public static void go(String[] arr, boolean[] visited, int depth) {
        if (depth == 3) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (visited[i]) {
                continue;
            }
            arr[depth] = alphabet[i];
            visited[i] = true;
            go(arr, visited, depth + 1);
            visited[i] = false;
        }
    }
}
