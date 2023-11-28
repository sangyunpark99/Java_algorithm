package 큰돌의터전알고리즘강의.three주차.배열돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int K;

    public static int[][] map;
    public static List<Rcs> rcsList;
    public static int answer;

    // 순열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        rcsList = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            int s = Integer.parseInt(stk.nextToken());
            rcsList.add(new Rcs(r - 1, c - 1, s)); // 인덱스는 1제거
        }

        // 순서가 있는 조합 - 순열
        permutation(new int[K], 0, new boolean[K]);

        System.out.println(answer);
    }

    public static void permutation(int[] a, int depth, boolean[] visited) {
        if (depth == K) {
            // 순서를 찾은 경우
            move(a);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (visited[i]) {
                continue; // 이미 방문한 경우
            }
            visited[i] = true;
            a[depth] = i;
            permutation(a, depth + 1, visited);
            visited[i] = false;
        }
    }

    public static void move(int[] arr) { // 회전 시작
        int[][] copyMap = copyMap(); // 초기화

        for (int i = 0; i < K; i++) { // K개 존재
            Rcs rcs = rcsList.get(arr[i]);
            int r = rcs.r;
            int c = rcs.c;
            int S = rcs.s;

            for (int s = 1; s <= S; s++) {
                //위
                int up = copyMap[r - s][c + s];
                for (int y = c + s; y > c - s; y--) {
                    copyMap[r - s][y] = copyMap[r - s][y - 1];
                }
                //오른쪽
                int right = copyMap[r + s][c + s];
                for (int x = r + s; x > r - s; x--) {
                    copyMap[x][c + s] = copyMap[x - 1][c + s];
                }
                copyMap[r - s + 1][c + s] = up;
                //아래
                int left = copyMap[r + s][c - s];
                for (int y = c - s; y < c + s; y++) {
                    copyMap[r + s][y] = copyMap[r + s][y + 1];
                }
                copyMap[r + s][c + s - 1] = right;
                //왼쪽
                for (int x = r - s; x < r + s; x++) {
                    copyMap[x][c - s] = copyMap[x + 1][c - s];
                }
                copyMap[r + s - 1][c - s] = left;
            }
        }

        findAnswer(copyMap);
    }

    public static void findAnswer(int[][] arr) {

        for (int i = 0; i < N; i++) {
            int colSum = 0;
            for (int j = 0; j < M; j++) {
                colSum += arr[i][j];
            }
            answer = Math.min(colSum, answer);
        }
    }

    public static int[][] copyMap() {
        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }

        return copy;
    }

    public static class Rcs {
        int r;
        int s;
        int c;

        Rcs(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}