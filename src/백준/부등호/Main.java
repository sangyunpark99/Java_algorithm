package 백준.부등호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static int K;
    public static char[] signs;
    public static int[] visited;
    public static List<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        signs = new char[K];
        visited = new int[10]; // 0 ~ 9

        String sign = br.readLine().replace(" ", "");
        signs = sign.toCharArray();

        answer = new ArrayList<>();

        dfs(0, "");

        Collections.sort(answer);

        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));
    }

    public static boolean check(char x, char y, char op) {
        if (x < y && op == '<') {
            return true;
        }
        return x > y && op == '>';
    }

    public static void dfs(int idx, String num) {
        if (idx == K + 1) {
            answer.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i] > 0) { // 방문 했으면 취소
                continue;
            }
            if (idx == 0 || check(num.charAt(idx - 1), (char) (i + '0'), signs[idx - 1])) {
                visited[i] = 1;
                dfs(idx + 1, num + i);
                visited[i] = 0; // 원상 복구
            }
        }
    }
}