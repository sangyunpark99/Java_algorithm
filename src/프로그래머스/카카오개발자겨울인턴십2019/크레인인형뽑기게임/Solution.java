package 프로그래머스.카카오개발자겨울인턴십2019.크레인인형뽑기게임;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(
                new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}
                },
                new int[]{1, 5, 3, 5, 1, 2, 1, 4}
        ));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int doll = getDoll(moves[i], board);
            if (doll > 0) {
                if (stack.isEmpty()) {
                    stack.add(doll);
                } else {
                    if (stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.add(doll);
                    }
                }
            }
        }

        return answer;
    }

    public int getDoll(int j, int[][] board) {

        int value = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][j - 1] > 0) { //
                value = board[i][j - 1];
                board[i][j - 1] = 0;
                break;
            }
        }

        return value;
    }
}
