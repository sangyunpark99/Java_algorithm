package 큰돌의터전알고리즘강의.three주차.뮤탈리스크;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] hp;
    static int res;

    static int[][][] visited;

    static int[][] attack = new int[][]{
            {9,3,1},
            {9,1,3},
            {3,9,1},
            {3,1,9},
            {1,3,9},
            {1,9,3},
            // 3P2
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        visited = new int[61][61][61];
        res = Integer.MAX_VALUE;
        hp = new int[3]; //

        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            hp[i] = Integer.parseInt(stk.nextToken()); // 시작점이 다르므로 하나씩 대입
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int bfs(){

        Queue<Hp> queue = new LinkedList();
        queue.add(new Hp(hp[0], hp[1], hp[2]));
        visited[hp[0]][hp[1]][hp[2]] = 1; // 피가 만땅일때 1을 추가해줌
        // 체력 줄이기

        while(!queue.isEmpty()){
            Hp hp = queue.poll();

            int a = hp.first;
            int b = hp.second;
            int c = hp.third;

            if(visited[0][0][0] == 1) break;
            for (int i = 0; i < 6; i++) {
                int na = Math.max(0,a - attack[i][0]); // - 방지
                int nb = Math.max(0,b - attack[i][1]);
                int nc = Math.max(0,c - attack[i][2]);

                if(visited[na][nb][nc] > 0) continue;
                visited[na][nb][nc] = visited[a][b][c] + 1;
                queue.add(new Hp(na,nb,nc));
            }
        }

        return visited[0][0][0] - 1; // 맨처음 자기 자신 빼준다
    }

    public static class Hp {
        int first;
        int second;
        int third;

        Hp(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
