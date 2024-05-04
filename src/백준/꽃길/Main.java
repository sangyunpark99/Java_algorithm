package 백준.꽃길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int N;
    public static int[][] visited;
    public static int[][] moneys;
    public static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        moneys = new int[N][N];
        visited = new int[N][N];

        res = 20000;

        for (int i = 0; i < N; i++) {
            moneys[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0);

        System.out.println(res);
    }

    public static int getMoney() {

        int money = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] > 0) {
                    money += moneys[i][j];
                }
            }
        }

        return money;
    }

    // 씨앗 찾기
    public static void dfs(int cnt) {
        if (cnt == 3) { // 3개를 찾은 경우, 가격 계산
            res = Math.min(res, getMoney());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i <= 0 || i >= N - 1 || j <= 0 || j >= N - 1 || visited[i][j] != 0) { // 범위 초과 확인
                    continue;
                }

                // 꽃이 잘 펼 수 있는 자리인지 확인
                if (visited[i - 1][j] == 1 || visited[i + 1][j] == 1 || visited[i][j + 1] == 1
                        || visited[i][j - 1] == 1) {
                    continue; // 다른꽃잎과 닿는 경우
                }

                // 꽃 피게 하기
                visited[i][j] = 2;
                visited[i - 1][j] = 1;
                visited[i + 1][j] = 1;
                visited[i][j + 1] = 1;
                visited[i][j - 1] = 1;

                dfs(cnt + 1);

                // 꽃 지게 하기
                visited[i][j] = 0;
                visited[i - 1][j] = 0;
                visited[i + 1][j] = 0;
                visited[i][j + 1] = 0;
                visited[i][j - 1] = 0;
            }
        }
    }
}