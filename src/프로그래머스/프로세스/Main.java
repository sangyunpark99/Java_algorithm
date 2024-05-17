package 프로그래머스.프로세스;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();

        char findValue = (char) ('A' + location);

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Node((char) ('A' + i), priorities[i]));
        }

        int cnt = 0; // 실행
        while (true) {
            boolean flag = false;
            Node cur = queue.poll();

            for (Node node : queue) {
                if (cur.priority < node.priority) { // 우선순위가 더 높은 프로세스가 있는 경우 다시 큐에 넣어주기
                    queue.add(cur);
                    flag = true; // 큐에 다시 넣었음을 알려주는 변수
                    break;
                }
            }

            if (flag) {
                continue;
            }

            // 실행을 시킨 경우
            cnt++;

            if (cur.value == findValue) { // 실행 시킨 프로세스와 찾으려는 프로세스가 같다면
                answer = cnt;
                break;
            }
        }

        return answer;
    }

    public class Node {
        char value;
        int priority;

        Node(char value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }
}
