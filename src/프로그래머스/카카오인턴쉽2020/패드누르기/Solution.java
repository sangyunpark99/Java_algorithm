package 프로그래머스.카카오인턴쉽2020.패드누르기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // hash맵 사용
    // 거리 계산

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int leftNumber = -1; // *을 -1로
        int rightNumber = -2; // #을 -2로

        List<Integer> leftNumbers = new ArrayList<>(List.of(1, 4, 7));
        List<Integer> rightNumbers = new ArrayList<>(List.of(3, 6, 9));

        Map<Integer, Node> screen = new HashMap<>();

        // 위치 초기화
        screen.put(0, new Node(3, 1));
        screen.put(-1, new Node(3, 0)); // #
        screen.put(-2, new Node(3, 0)); // *

        int number = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                screen.put(number, new Node(i, j));
                number++;
            }
        }

        for (int i = 0; i < numbers.length; i++) {

            int curNumber = numbers[i];

            if (leftNumbers.contains(curNumber)) { // 1,4,7 인 경우
                leftNumber = curNumber;
                answer.append("L");
            } else if (rightNumbers.contains(curNumber)) { // 3,6,9 인 경우
                rightNumber = curNumber;
                answer.append("R");
            } else { // 2,5,8,0인 경우
                Node numberPos = screen.get(curNumber);
                Node leftPos = screen.get(leftNumber);
                Node rightPos = screen.get(rightNumber);

                // 위치 기반으로 계산
                int leftGap = Math.abs(leftPos.x - numberPos.x) + Math.abs(leftPos.y - numberPos.y);
                int rightGap = Math.abs(rightPos.x - numberPos.x) + Math.abs(rightPos.y - numberPos.y);

                if (leftGap < rightGap) {
                    answer.append("L");
                    leftNumber = curNumber;
                } else if (leftGap > rightGap) {
                    answer.append("R");
                    rightNumber = curNumber;
                } else if (leftGap == rightGap) { // 차이가 같은 경우
                    if ("left".equals(hand)) {
                        answer.append("L");
                        leftNumber = curNumber;
                    } else {
                        answer.append("R");
                        rightNumber = curNumber;
                    }
                }
            }
        }

        return answer.toString();
    }

    public class Node {
        int x;
        int y;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
