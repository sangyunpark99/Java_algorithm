package 백준.특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static List<List<Integer>> list = new ArrayList<>();

    public static boolean check = false;
    public static List<Integer> answer = new ArrayList<>();
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cityNum = Integer.parseInt(st.nextToken());
        int roadNum = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken()); // 거리 정보
        int startCity = Integer.parseInt(st.nextToken()); // 출발 도시

        visited = new int[cityNum + 1];
        Arrays.fill(visited, -1);

        for (int i = 0; i < cityNum + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < roadNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
        }

        bfs(startCity);

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == distance) {
                answer.add(i);
            }
        }

        Collections.sort(answer);

        if (answer.size() > 0) {
            for (int value : answer) {
                System.out.println(value);
            }

            return;
        }

        System.out.println(-1);
    }

    public static void bfs(int startCity) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startCity);
        visited[startCity]++;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int value : list.get(cur)) {
                if (visited[value] == -1) { // 방문하지 않은 경우
                    visited[value] = visited[cur] + 1; // 이전 방문 노드 + 1
                    queue.add(value);
                }
            }
        }
    }
}
