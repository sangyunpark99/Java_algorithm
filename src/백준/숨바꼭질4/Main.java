package 백준.숨바꼭질4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, K;
    public static List<Integer> list;
    public static int[] visited;
    public static int[] prev; // 추적은 prev 배열로 해준다.

    public static final int MAX = 200_004;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new int[MAX + 1];
        prev = new int[MAX + 1];

        visited[N] = 1;

        bfs();

        // 횟수 누적을 어떻게 할까?
        for (int i = K; i != N; i = prev[i]) { // 끝에서부터 추적해주기
            list.add(i);
        }

        list.add(N);

        StringBuilder reverseList = new StringBuilder();

        Collections.reverse(list);

        for (int value : list) {
            reverseList.append(value + " ");
        }

        reverseList.deleteCharAt(reverseList.length() - 1);

        StringBuilder res = new StringBuilder();

        res.append(visited[K] - 1 + "\n");
        res.append(reverseList + "\n");
        bw.write(res + "\n");
        bw.close();
        br.close();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                break;
            }

            for (int value : new int[]{cur + 1, cur - 1, cur * 2}) {
                if (value < 0 || value >= MAX) {
                    continue;
                }

                if (visited[value] == 0) {
                    visited[value] = visited[cur] + 1;
                    prev[value] = cur;
                    queue.add(value);
                }
            }
        }
    }
}