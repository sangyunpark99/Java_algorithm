package 큰돌의터전알고리즘강의.three주차.뱀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int K;
    public static int L;
    public static int[][] map;
    public static List<Move> moves;
    public static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[104][104];
        moves = new ArrayList<>();
        visited = new boolean[104][104];
        Deque<Node> dq = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());
            map[y - 1][x - 1] = 1; // 사과의 위치 저장
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) { // 움직일
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(stk.nextToken());
            int dir = stk.nextToken().equals("D") ? 1 : 3;

            moves.add(new Move(time, dir));
        }

        int idx = 0;
        int dir = 1;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{-1, 0, 1, 0};

        int time = 0;
        dq.addLast(new Node(0, 0));
        while (!dq.isEmpty()) {
            time++;
            Node cur = dq.getFirst();
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) { // 벽 + 자기몸
                break;
            }

            if (map[ny][nx] != 1) { // 사과가 아닌 경우
                visited[dq.getLast().y][dq.getLast().x] = false;
                dq.pollLast(); // 꼬리 제거
            } else { // 사과인 경우
                map[ny][nx] = 0;
            }

            dq.addFirst(new Node(ny, nx)); // 몸통 추가
            visited[ny][nx] = true; // 방문 처리

            if (idx < moves.size() && time == moves.get(idx).time) { // 현재 진행 시간
                dir = (dir + moves.get(idx).dir) % 4;
                idx++;
            }
        }

        System.out.println(time);
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Move {
        int time;
        int dir;

        public Move(int time, int dir) {
            this.time = time;
            this.dir = dir;
        }
    }

}
