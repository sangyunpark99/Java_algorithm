package 큰돌의터전알고리즘강의.three주차.숨바꼭질4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int[] visited;
    public static int[] cnt;
    public static int MAX = 200002; // 2배를 해줄 경우를 생각
    public static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        prev = new int[MAX];
        visited = new int[MAX];

        bfs(n);

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = m; i!=n ; i=prev[i]){ // 조건문 잘 활ㅁ
            answer.add(i);
        }

        answer.add(n);

        System.out.println(visited[m] - 1); // 시작할때 하나 제거
        Collections.reverse(answer);
        for(int value : answer){
            System.out.print(value);
            System.out.print(" ");
        }
    }

    public static void bfs(int n){ // 방문
        visited[n] = 1;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(cur == m){
                break;
            }

            int[] select = new int[]{
                    cur-1,
                    cur+1,
                    cur*2
            };

            for(int next : select){
                if(next < 0 || next >= MAX || visited[next] >= 1) continue;
                if(visited[next] == 0){
                    visited[next] = visited[cur] + 1;
                    queue.add(next);
                    prev[next] = cur; // 이전 값 추적하는 방 - trace
                }
            }
        }
    }
}
