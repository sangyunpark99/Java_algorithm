package 카카오2024인턴쉽.two;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi",
                        "frodo ryan", "neo muzi"}));
    }

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> friendsMap = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            friendsMap.put(friends[i], i);
        }

        // 0 : muzi, 1 : ryan, 2 : frodo, 3 : neo

        int[][] giveAndTaker = new int[friends.length][friends.length];

        for (int i = 0; i < gifts.length; i++) {
            String[] giveTaker = gifts[i].split(" ");
            String giver = gifts[0];
            String taker = gifts[1];

            giveAndTaker[friendsMap.get(giver)][friendsMap.get(taker)]++;
        }

        return answer;
    }
}
