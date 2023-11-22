package 프로그래머스.카카오인턴쉽2020.보석쇼핑;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(
                new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
    }

    public int[] solution(String[] gems) {
        int[] answer = {};

        // 보석 종류
        Set<String> gemSet = new HashSet<>(List.of(gems));
        answer = findTerm(gemSet, gems);

        return answer;
    }

    public int[] findTerm(Set<String> gameSet, String[] gems) {
        int l = 0;
        int r = 0;
        Node minNode = new Node(l, r, Integer.MAX_VALUE);

        Map<String, Integer> list = new HashMap<>();
        while (l != gems.length) {
            if (list.size() == gameSet.size()) { // 다 찾은 경우
                if (minNode.distance >= Math.abs(l - r)) {
                    if (minNode.distance == Math.abs(l - r) && minNode.l > l) {
                        minNode = new Node(l, r - 1);
                    } else {
                        minNode = new Node(l, r - 1);
                    }
                }

                if (list.get(gems[l]) - 1 == 0) {
                    list.remove(gems[l]);
                } else {
                    list.put(gems[l], list.get(gems[l]) - 1);
                }

                l++;
            } else { // 다 못찾은 경우
                if (r < gems.length) {
                    list.put(gems[r], list.getOrDefault(gems[r], 0) + 1);
                    r++;
                } else {
                    break;
                }
            }
        }

        return new int[]{minNode.l + 1, minNode.r + 1};
    }

    class Node {
        int l;
        int r;
        int distance;

        Node(int l, int r, int distance) {
            this.l = l;
            this.r = r;
            this.distance = distance;
        }

        Node(int l, int r) {
            this.l = l;
            this.r = r;
            this.distance = Math.abs(l - r);
        }
    }
}