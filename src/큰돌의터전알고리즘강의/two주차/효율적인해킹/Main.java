package 큰돌의터전알고리즘강의.two주차.효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// dfs
public class Main {

    public static int n;
    public static int m;

    // 인접 행렬
    public static ArrayList<Integer>[] graph;
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(); // 무조건 sb로!!

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[n+1];

        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            graph[b].add(a);
        }

        int[] dp = new int[n+1];

        int maxValue = Integer.MIN_VALUE;

        for (int i = 1; i < n+1; i++) {
            // 방문 초기화
            visited = new int[n+1]; // 0 ~ 4
            Arrays.fill(visited,0);
            visited[i] = 1;
            dp[i] = dfs(i);
            maxValue = Math.max(dp[i],maxValue);
        }

        for (int i = 0; i < dp.length; i++) {
            if(maxValue == dp[i]){
                sb.append(i+" ");
            }
        }
        System.out.println(sb); // sb로 해!
    }

    public static int dfs(int here){ // 맨처음 타고들어와
        int ret = 1;

        for (int a : graph[here]) { // 노드가 하나도 없는 경우 1반환
            if(visited[a] == 0){
                visited[a] = 1;
                ret += dfs(a);
            }
        }

        return ret;
    }
}
