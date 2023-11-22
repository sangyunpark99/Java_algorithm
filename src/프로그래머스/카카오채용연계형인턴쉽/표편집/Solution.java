package 프로그래머스.카카오채용연계형인턴쉽.표편집;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution(8, 2,
                        new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
    }

    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        List<Node> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < cmd.length; i++) {
            String c = cmd[i];

            if (c.contains("D")) { // 아래로 이동

            }

            if (c.contains("C")) { // 줄 삭제

            }

            if (c.contains("U")) { // 위로 이동

            }

            if (c.contains("Z")) {

            }
        }

        return answer;
    }

    class Node {
        int idx;
        int front;
        int back;

        Node(int idx, int front, int back) {

        }
    }
}
