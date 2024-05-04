package 백준.완전이진트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static int K;
    public static ArrayList<ArrayList<Integer>> ans;
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        ans = new ArrayList<>();
        numbers = new int[1030];

        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < K; i++) {
            ans.add(new ArrayList<>());
        }

        dfs(0, (int) Math.pow(2, K) - 2, 0);

        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int start, int end, int level) {
        if (start > end) {
            return;
        }

        if (start == end) { // start == end는 자기 자신을 가리킨다.
            ans.get(level).add(numbers[start]);
            return;
        }

        int mid = (start + end) / 2;
        ans.get(level).add(numbers[mid]); // 중앙 값 넣고
        dfs(start, mid - 1, level + 1); // 중앙 이전 범위
        dfs(mid + 1, end, level + 1); // 중앙 이후 범위
    }
}
