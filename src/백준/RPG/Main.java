package 백준.RPG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static Quest[] quests;
    private static boolean[] visited;
    private static Character character;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());

        character = new Character();
        quests = new Quest[n];
        dp = new int[1004][1004]; // dp
        visited = new boolean[51]; // 방문 처리

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int STR = Integer.parseInt(st.nextToken());
            int INT = Integer.parseInt(st.nextToken());
            int POINT = Integer.parseInt(st.nextToken());
            quests[i] = new Quest(STR, INT, POINT);
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(findMaxQuestValue(character.STR, character.INT));
    }

    private static int findMaxQuestValue(int STR, int INT) { // 힘, 지략

        int ret = dp[STR][INT];

        if (ret != -1) {
            return ret;
        }

        ret = 0;
        dp[STR][INT] = 0;
        int point = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) { // 퀘스트 하나씩 탐색
            if (quests[i].STR <= STR || quests[i].INT <= INT) { //
                ret++; // 퀘스트 갯수 하나 추가
                if (!visited[i]) {
                    visited[i] = true;
                    point += quests[i].point; // 포인트 추가하기
                    list.add(i); // 퀘스트로 진행된 번호 추가
                }
            }
        }

        // 추가한 포인트 분배
        for (int p = 0; p <= point; p++) { // 얻을 수 있는 포인트는 0 ~ 1000
            int nextSTR = Math.min(1000, STR + p);
            int nextINT = Math.min(1000, INT + point - p);
            ret = Math.max(ret, findMaxQuestValue(nextSTR, nextINT));
            dp[STR][INT] = ret;
        }

        for (int here : list) { // 원상 복구
            visited[here] = false;
        }

        return ret;
    }

    static class Quest { // 퀘스트
        int STR;
        int INT;
        int point;

        public Quest(int STR, int INT, int point) {
            this.STR = STR;
            this.INT = INT;
            this.point = point;
        }
    }

    static class Character { // 캐릭터
        int STR;
        int INT;

        public Character() {
            this.STR = 1;
            this.INT = 1;
        }
    }
}