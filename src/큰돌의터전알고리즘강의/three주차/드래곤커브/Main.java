package 큰돌의터전알고리즘강의.three주차.드래곤커브;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static boolean[][] map = new boolean[101][101];
    public static int[] dy = {0, -1, 0, 1};
    public static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragon(x, y, d, g);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dragon(int x, int y, int d, int g) { // 지정해 놓은 세대까지
        List<Integer> list = new ArrayList<>();
        list.add(d);

        System.out.println();
        for (int i = 1; i <= g; i++) { // g세대까지
            System.out.println(i + "세대");
            for (int j = list.size() - 1; j >= 0; j--) { // 더해서 역순
                list.add((list.get(j) + 1) % 4);
            }
            System.out.println(list);
        }

        map[y][x] = true;
        for (Integer dir : list) {
            y += dy[dir];
            x += dx[dir]; // 누적
            map[y][x] = true;
        }
    }
}
