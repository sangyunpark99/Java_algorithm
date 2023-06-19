package 백준.경로찾기;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int[][] map;
    public static boolean[] visit;
    public static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            for (int j = 0; j < n; j++) {
                if(!visit[j] && map[i][j] == 1){
                    bfs(i,j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(y);

        while(!queue.isEmpty()){
            int data = queue.poll();

            for (int i = 0; i < n; i++) {
                    if(!visit[i] && map[data][i] == 1){
                    queue.add(i);
                    map[x][i] = 1;
                    visit[i] = true;
                }
            }
        }
    }
}
