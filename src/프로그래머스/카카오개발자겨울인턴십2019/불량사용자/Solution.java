package 프로그래머스.카카오개발자겨울인턴십2019.불량사용자;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {

    List<List<String>> ids = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                        new String[]{"fr*d*", "abc1**"}));
    }

    public int solution(String[] user_id, String[] banned_id) {
        Boolean[] visited = new Boolean[user_id.length];
        Arrays.fill(visited, false);
        dfs(user_id, banned_id, visited, 0, 0);

        return ids.size();
    }

    public void dfs(String[] user_id, String[] banned_id, Boolean[] visited, int start, int count) {
        if (banned_id.length == count) { // 종료 조건
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    list.add(user_id[i]);
                }
            }

            if (!ids.contains(list)) {
                ids.add(list);
            }

            return;
        }

        for (int i = start; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                String user = user_id[j];
                String banned = banned_id[i];

                boolean checked = true;

                if (banned.length() != user.length()) { // 길이가 안맞는 경우
                    checked = false;
                } else {
                    for (int k = 0; k < user.length(); k++) {
                        if (banned.charAt(k) == '*') {
                            continue;
                        }
                        if (banned.charAt(k) != user.charAt(k)) {
                            checked = false;
                            break;
                        }
                    }
                }
                // 찾았으면 다음거로
                if (checked && !visited[j]) {
                    visited[j] = true;
                    dfs(user_id, banned_id, visited, i + 1, count + 1);
                    visited[j] = false;
                }
            }
        }
    }
}