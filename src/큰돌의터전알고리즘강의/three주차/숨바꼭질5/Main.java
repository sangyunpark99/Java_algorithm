package 큰돌의터전알고리즘강의.three주차.숨바꼭질5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int k;
    public static int turn = 1;
    public static int MAX = 500000;

    public static int[][] visited;
    public static boolean ok = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new int[2][MAX+1];

        if(n == k){
            System.out.println(0);
            return;
        }

        visited[0][n] = 1; // 방문
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty()){
            k += turn; // 동생의 위치
            if(k > MAX) break;
            if(visited[turn%2][k] > 0){ // 수빈이가 이미 방문을 했다면
                ok = true;
                break;
            }

            int qSize = q.size(); // 플루드 필
            for (int i = 0; i < qSize; i++) {
                int cur = q.poll();
                int[] selects = new int[]{
                        cur+1,
                        cur-1,
                        2*cur
                };
                for(int next : selects){ // 수빈이가 이동할 다음 경로
                    if(next < 0 || next > MAX || visited[turn%2][next] > 0) continue;
                    visited[turn%2][next] = visited[(turn-1)%2][cur] + 1;
                    if(next == k){ // 이동하다가 만난 경우
                        ok = true;
                        break;
                    }
                    q.add(next); // 넣어주고
                }
                if(ok){ // 굳이 for문 돌릴 필요 없다.
                    break;
                }
            }
            if(ok){ // 굳이 for문 돌릴 필요 없다.
                break;
            }

            turn++;
        }

        if(ok){
            System.out.println(turn);
        }else{
            System.out.println(-1);
        }
    }
}
