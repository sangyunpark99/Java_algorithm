package pre코딩테스트연습.three_four.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static int[][] visited;
    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{-1,0,1,0};
    public static int h;
    public static int w;

    public static int zeroY;
    public static int zeroX;
    public static ArrayList<Integer> zeros;

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().solution(new int[][]{{1},{0}})));
    }

    public int[][] solution(int[][] n) {

        h = n.length;
        w = n[0].length;
        zeros = new ArrayList<>();

        int[][] answer = new int[h][w];

        visited = new int[h][w];

        // zeroY, zeroX 좌표 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(n[i][j] == 0){
                    zeroY = i;
                    zeroX = j;

                    zeros.add(i);
                    zeros.add(j);
                }
            }
        }



        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(n[i][j] == 1){
                    visited[i][j] = 1;
                    answer[i][j] = bfs(i,j);
                    initVisited();
                }
            }
        }

        return answer;
    }

    public static int bfs(int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);

        while(queue.size()>0){
            int y = queue.poll();
            int x = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
                if(visited[ny][nx] == 0){
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.add(ny);
                    queue.add(nx);
                }
            }

        }

        // 최솟값 찾기
        int ans = Integer.MAX_VALUE;
        int idx = 0;
        while(idx < zeros.size()){

            // 0이 나오는 좌표값
            int y = zeros.get(idx);
            int x = zeros.get(idx+1);

            ans = Math.min(visited[y][x], ans);

            idx+=2;
        }

        return ans - 1;
    }

    public static void initVisited(){
        for (int i = 0; i < h; i++) {
            Arrays.fill(visited[i], 0);
        }
    }
}
