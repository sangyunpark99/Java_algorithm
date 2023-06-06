package 프로그래머스.문자열내림차순으로배치하기;

    import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        new Solution().solution("Zbcdefg");
    }

    public String solution(String s) {
        StringBuffer answer = new StringBuffer();

        String[] ans = s.split("");

        Arrays.sort(ans);

        for (int i = ans.length-1; i >= 0 ; i--) {
            answer.append(ans[i]);
        }

        System.out.println(answer);

        return String.valueOf(answer);
    }
}
