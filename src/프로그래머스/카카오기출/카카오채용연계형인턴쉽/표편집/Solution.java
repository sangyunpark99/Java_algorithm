package 프로그래머스.카카오기출.카카오채용연계형인턴쉽.표편집;

import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(8, 2, new String[]{
                "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"
        }));
    }

    Stack<Node> stack;

    public class Node {

        int data;
        Node prev, next;

        public Node() {

        }

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Node remove() {
            prev.next = next;
            next.prev = prev;
            if (this.next.data == -1) { // 마지막 노드인 경우 -> 삭제시 이전 노드로
                return this.prev;
            } else {
                return this.next;
            }
        }

        public void restore() { // 재연결
            prev.next = this;
            next.prev = this;
        }
    }

    public Node init(int n) {
        Node initNode = new Node(-1); // 시작 노드
        Node prevNode = initNode;
        Node curNode = null;

        for (int i = 0; i < n; i++) {
            curNode = new Node(i);
            prevNode.next = curNode;
            curNode.prev = prevNode;

            prevNode = curNode;
        }

        Node endNode = new Node(-1);
        curNode.next = endNode;
        return initNode.next;
    }

    public String solution(int n, int k, String[] cmd) {
        Node cursor = init(n);
        stack = new Stack<>();
        for (int i = 0; i < k; i++) { // 시작 커서 이동
            cursor = cursor.next;
        }

        for (int i = 0; i < cmd.length; i++) {
            String[] command = cmd[i].split(" ");
            String op = command[0];

            if ("U".equals(op)) {
                int opNum = Integer.parseInt(command[1]);
                cursor = up(cursor, opNum);
            } else if ("D".equals(op)) {
                int opNum = Integer.parseInt(command[1]);
                cursor = down(cursor, opNum);
            } else if ("C".equals(op)) {
                cursor = delete(cursor);
            } else { // 복구
                restore();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("O");
        }

        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop().data, 'X');
        }

        return sb.toString();
    }

    Node up(Node cur, int num) {
        for (int i = 0; i < num; i++) {
            cur = cur.prev;
        }

        return cur;
    }

    Node down(Node cur, int num) {
        for (int i = 0; i < num; i++) {
            cur = cur.next;
        }

        return cur;
    }

    Node delete(Node cur) {
        stack.push(cur);
        cur = cur.remove();
        return cur;
    }

    void restore() {
        Node dNode = stack.pop();
        dNode.restore();
    }
}
