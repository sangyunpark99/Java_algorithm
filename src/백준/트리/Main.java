package 백준.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 77퍼에서 틀
public class Main {

    public static int n;
    public static int[] visited;
    public static int remove;
    public static List<List<Integer>> list = new ArrayList<>();
    public static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new int[n]; // 방문한 노드

        remove = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        int root = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) { // 루트노드
                root = i;
                continue;
            }

            if (i == remove) {
                continue;
            }

            list.get(arr[i]).add(i);
        }

        if (root == remove) { // 루트 노드가 제거되는 경우 - 반례
            System.out.println(0);
            return;
        }

        dfs(root);

        System.out.println(res);
    }

    public static void dfs(int start) {

        if (list.get(start).size() == 0) { // 크기가 없는 경우, 리프 노드임
            res++;
            return;
        }

        for (int i = 0; i < list.get(start).size(); i++) {
            int node = list.get(start).get(i);
            if (visited[node] == 0) { // 방문한적 없으면 + 제거되는 노드가 아닌 경우
                visited[node] = 1; // 방문처리
                dfs(node); // 탐색
            }
        }
    }
}