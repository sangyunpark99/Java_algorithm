package 백준.물통복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 핵심 포인트
// A와B가 각각 10만개씩 이므로, 2차원 배열로 표현하기엔 너무 많은 메모리가 든다.

public class Main {

    private static int a, b, c, d;
    private static int answer = Integer.MAX_VALUE;
    private static HashMap<String, Boolean> visited = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        bfs();

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0, 0));
        visited.put("0,0", true);

        while (queue.size() > 0) {
            AB cur = queue.poll();
            int curA = cur.a;
            int curB = cur.b;
            int curTurn = cur.turn;

            if (curA == c && curB == d) {
                answer = Math.min(answer, cur.turn);
                continue;
            }

            for (AB ab : getNextStatus(curA, curB, curTurn)) {
                if (visited.get(ab.a + "," + ab.b) != null) { // 이미 방문한 경우
                    continue;
                }

                queue.add(ab); // 방문 처리
                visited.put(ab.a + "," + ab.b, true);
            }
        }
    }

    public static List<AB> getNextStatus(int curA, int curB, int curTurn) {
        List<AB> nextStatus = new ArrayList<>();
        // 물통 채우기
        nextStatus.add(new AB(a, curB, curTurn + 1));
        nextStatus.add(new AB(curA, b, curTurn + 1));
        // 물통 비우기
        nextStatus.add(new AB(0, curB, curTurn + 1)); // A 물통 비우기
        nextStatus.add(new AB(curA, 0, curTurn + 1)); // B 물통 비우기
        // 물 옮기기
        int waterAtoB = Math.min(curA, b - curB); // A -> B로 옮기는 물의 양
        int waterBtoA = Math.min(curB, a - curA); // B -> A로 옮기는 물의 양
        nextStatus.add(new AB(curA - waterAtoB, curB + waterAtoB, curTurn + 1));
        nextStatus.add(new AB(curA + waterBtoA, curB - waterBtoA, curTurn + 1));

        return nextStatus;
    }

    public static class AB {
        int a;
        int b;
        int turn;

        public AB(int a, int b, int turn) {
            this.a = a;
            this.b = b;
            this.turn = turn;
        }
    }
}