package 프로그래머스.코테;

import java.util.Arrays;

class Solution {
    public static boolean[] visited;
    public static boolean[] secondVisited;
    public static int cardsLength;
    public static int count;
    public static int firstBoxGroup = Integer.MIN_VALUE;
    public static int secondBoxGroup = Integer.MIN_VALUE;

    public static void main(String[] args) {

        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};

        int answer = 0;
        visited = new boolean[cards.length];
        cardsLength = cards.length;

        for (int i = 0; i < cards.length; i++) {
            visited = new boolean[cards.length];
            find(i, 1, cards, 1);
            count = 0;
        }

        System.out.println(firstBoxGroup);
        System.out.println(Arrays.toString(visited));

        if (firstBoxGroup == 0) {
            System.out.println(0);
            return;
        }

        secondVisited = new boolean[cards.length];

        for (int i = 0; i < secondVisited.length; i++) {
            secondVisited[i] = visited[i];
        }

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                for (int j = 0; j < cards.length; j++) {
                    visited[j] = secondVisited[j];
                }
                find(i, 1, cards, 2);
                count = 0;
            }
        }

        System.out.println(secondBoxGroup);
    }

    public static void find(int boxNumber, int turn, int[] cards, int check) {
        if (turn == cardsLength) {
            if (check == 1) {
                firstBoxGroup = 0;
            } else {
                secondBoxGroup = 0;
            }
            return;
        }

        if (visited[cards[boxNumber] - 1]) {
            if (check == 1) {
                firstBoxGroup = Math.max(firstBoxGroup, count);
            } else {
                secondBoxGroup = Math.max(secondBoxGroup, count);
            }
            return;
        }

        visited[cards[boxNumber] - 1] = true;
        count += 1;
        find(cards[boxNumber] - 1, turn + 1, cards, check);
    }
}
