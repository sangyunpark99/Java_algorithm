package 큰돌의터전알고리즘강의.three주차.주난의난;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n; // 1 부터 300
    public static int m; // 1 부터 300

    // 주난이 위치
    public static int y1;
    public static int x1;

    public static String[][] map;
    public static int[][] visited;

    // 범인의 위치
    public static int y2;
    public static int x2;

    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{-1,0,1,0};

    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        y1 = Integer.parseInt(st.nextToken()) - 1; // index는 -1
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;

        map = new String[n][m];
        visited = new int[n][m];

        cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
           map[i] = st.nextToken().split("");
        }

        bfs();
    }

    public static void bfs(){ // queue를 2개 사용해라 -> 어떻게?
        visited[y1][x1] = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y1,x1));

        while(!map[y2][x2].equals("0")){ // 목표지점이 0이 아닐때까지
            cnt++; // 이미 한단계 진행함
            Queue<Node> temp = new LinkedList<>(); // 다음에 출발할 지점

            while(!q.isEmpty()){
                Node cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] > 0) continue;
                    visited[ny][nx] = cnt; // 한 턴

                    if(!map[ny][nx].equals("0")){ // 0 이외의 문자를 만난 경우
                        map[ny][nx] = "0";
                        temp.add(new Node(ny,nx)); // 다음에 이동해야할 턴임
                    }else{
                        q.add(new Node(ny,nx)); // 더 가야하므로 q에 넣어주기
                    }
                }
            }
            q = temp; // 다음에 이동해야할 지ㅇ
        }
        System.out.println(visited[y2][x2]);
    }

    public static class Node{
        int x;
        int y;

        Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
}
