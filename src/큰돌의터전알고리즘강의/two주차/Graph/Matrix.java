package 큰돌의터전알고리즘강의.two주차.Graph;

import java.util.Arrays;

public class Matrix {

    static int[] visited = new int[10];
    static int[][] graph = new int[10][10];

    public static void main(String[] args) {
        graph = new int[10][10];

        visited = new int[10];

        Arrays.fill(visited,0);

        // 양방향 간선
        graph[1][2] = 1; graph[2][1] = 1;
        graph[1][3] = 1; graph[3][1] = 1;
        graph[3][4] = 1; graph[4][3] = 1;

        // 인접행렬 2중 포문
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(graph[i][j] == 1 && visited[i] == 0){ // 간선과 연결되어 있는 부분 찾기
                    go(i);
                }
            }
        }
    }

    public static void go(int from){
        visited[from] = 1;
        System.out.println(from);
        for (int j = 0; j < 10; j++) {
            if(visited[j] == 1){ // 이미 방문한 경우
                continue;
            }
            if(graph[from][j] == 1){ // 방문하지 않은 경우
                go(j); // 재귀호출
            }
        }

        return;
    }
}
