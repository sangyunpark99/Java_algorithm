package 프로그래머스.lv3스티커모으기2;

import java.util.Arrays;

public class Solution {

    private static int[] stickers;
    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}));
    }

    public static int solution(int sticker[]) {
        int answer = 0;
        stickers = sticker;
        int n = stickers.length;
        dp = new int[sticker.length]; // 현재 턴에 최댓값

        if (n == 1) { // 1개만 있는 경우
            return stickers[0];
        }

        // 첫번재 원소 선택한 경우, 첫번째 원소를 선택하지 않은 경우
        int firstCheck = dfs(0, true);
        System.out.println(Arrays.toString(dp));
        dp = new int[sticker.length];
        int firstNotCheck = dfs(1, false);
        answer = Math.max(firstNotCheck, firstNotCheck);

        return answer;
    }

    private static int dfs(int curIdx, boolean firstPicked) { // 0번째 index부터 시작

        if (firstPicked) { // 넘겨
            if (curIdx == stickers.length - 1) { // 마지막 원소는 스킵
                return 0;
            }
        }

        if (curIdx >= stickers.length) { // 최종 index
            return 0;
        }

        if (dp[curIdx] != 0) {
            return dp[curIdx];
        }

        int ret = 0;

        // 현재 스티커를 선택하는 경우
        ret += Math.max(dfs(curIdx + 2, firstPicked) + stickers[curIdx], dfs(curIdx + 1, firstPicked));
        dp[curIdx] = ret;

        return ret;
    }
}