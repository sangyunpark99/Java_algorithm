package 큰돌의터전알고리즘강의.two주차.Graph;

// 1 0 1
// 1 0 1
// 0 1 1

import java.util.Arrays;

public class Map { // y,x로 해라!

    public static int[][] map = new int[][]{{1,0,1},{1,0,1},{0,1,1}};
    public static int[][] visited = new int[3][3];

    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    public static void main(String[] args) {

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                visited[i][j] = 0;
            }
        }

        int y = 0;
        int x = 0;

        go(y,x);
    }

    public static void go(int y, int x){
        visited[y][x] = 1;
        System.out.printf("%d,%d 방문\n",y,x);
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(ny<0 || ny>=3 || nx < 0 || nx>=3) continue;
            if(map[ny][nx] == 0) continue;
            if(visited[ny][nx] == 1) continue;
            go(ny,nx);
        }
        return;
    }
}
