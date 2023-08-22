package 큰돌의터전알고리즘강의.three주차.숨바꼭질2;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int MAX = 100000;
    public static int n;
    public static int m;
    public static int answer;
    public static int[] visited;
    public static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        visited = new int[MAX+1];
        cnt = new int[MAX+1];

        Arrays.fill(visited,0);

        visited[n] = 1;
        cnt[n] = 1;

        if(n == m){
            System.out.println(0);
            System.out.println(1);
            return;
        }

        bfs();

        System.out.println(visited[m] - 1);
        System.out.println(cnt[m]);
    }

    // 가장 빠른 시간 - BFS
    public static void bfs(){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            int[] select = new int[]{
                    cur-1,
                    cur+1,
                    cur*2
            };

            for(int next : select){
                if(next < 0 || next > MAX) continue;
                if(visited[next] == 0){
                    queue.add(next);
                    visited[next] = visited[cur] + 1;
                    cnt[next] += cnt[cur];
                }else if(visited[next] == visited[cur] + 1){ // 현재 값의 다음이라면
                    cnt[next] += cnt[cur];
                }
            }
        }
    }
}
