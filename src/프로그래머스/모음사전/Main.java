package 프로그래머스.모음사전;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

    }

    public int cnt = 0;
    public HashMap<String, Integer> map;

    public int solution(String word) {
        int answer = 0;

        map = new HashMap<>();

        dfs("", 0);

        answer = map.get(word);

        return answer;
    }

    public void dfs(String word, int depth) {

        map.put(word, cnt);

        if (depth == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            cnt++;
            dfs(word + change(i), depth + 1);
        }
    }

    public String change(int n) {
        if (n == 0) {
            return "A";
        } else if (n == 1) {
            return "E";
        } else if (n == 2) {
            return "I";
        } else if (n == 3) {
            return "O";
        }

        return "U";
    }
}
