package 백준.물통;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 6가지 이동 케이스
    public static int[] Sender = {0, 0, 1, 1, 2, 2};
    public static int[] Receiver = {1, 2, 0, 2, 0, 1};
    public static boolean[][] visited; // A,B의 무게만 있으면 C의 무게가 고정된다.
    public static boolean[] answer;
    public static int[] now;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        now = new int[3];

        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());

        visited = new boolean[201][201];
        answer = new boolean[201];

        bfs();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true; // 마지막꺼는 제외

        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;

            for (int k = 0; k < 6; k++) { // 6가지 경우
                int[] next = {A, B, C};
                next[Receiver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;

                if (next[Receiver[k]] > now[Receiver[k]]) { // 물이 넘치는 경우
                    // 초과하는 만큼 다시 이전 물통에 넣어 줌
                    next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]];
                    next[Receiver[k]] = now[Receiver[k]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));

                    if (next[0] == 0) { // A의 물의 양이 0일때 C의 물의 무게를 정답변수에 저장
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    public static class AB {
        int A;
        int B;

        public AB(int a, int b) {
            A = a;
            B = b;
        }
    }
}
