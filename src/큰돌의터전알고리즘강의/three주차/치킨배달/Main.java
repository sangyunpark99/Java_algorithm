package 큰돌의터전알고리즘강의.three주차.치킨배달;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 조합 + 백트래킹
public class Main {

    public static int n,m;
    public static int[][] map;
    public static int ans;
    public static ArrayList<Node> chickenList;
    public static ArrayList<Node> houseList;
    public static boolean[] chickenVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new int[n][n];
        chickenList = new ArrayList<>();
        houseList = new ArrayList<>();

        // 치킨 리스트, 집 리스트 따로 저장
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 1){
                    houseList.add(new Node(j,i));
                }else if(map[i][j] == 2){
                    chickenList.add(new Node(j,i));
                }
            }
        }

        ans = Integer.MAX_VALUE;
        chickenVisited = new boolean[chickenList.size()];
        go(0,0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void go(int start, int cnt){
        if(cnt == m){
            int tot = 0;

            for (int i = 0; i < houseList.size(); i++) { // 각 집 노드마다
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chickenList.size(); j++) {
                    if(chickenVisited[j]){ // 선택받은 치킨 집인경우
                        int dis = Math.abs(houseList.get(i).x - chickenList.get(j).x) + Math.abs(houseList.get(i).y - chickenList.get(j).y);
                        tmp = Math.min(tmp,dis); // 최소 거리 찾기
                    }
                }
                tot += tmp;
            }
            ans = Math.min(ans,tot);
            return;
        }

        // 백 트래킹
        for (int i = start; i < chickenList.size(); i++) {
            chickenVisited[i] = true;
            go(i+1, cnt+1);
            chickenVisited[i] = false;
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
