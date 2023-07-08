package pre코딩테스트연습.three_one.four;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("00001110001"));
    }

    public String solution(String s) {
        String answer = "";

        if(s.charAt(s.length()-1) == '1'){
            s+="00";
        }

        // 1의 갯수 새자
        int cntOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                cntOne++;
            }
        }

        ArrayList<String> push = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                String sub = s.substring(i,i+3);
                i = i + 2;
                push.add(sub);
            }
        }

        if(push.size() > 2){ // 두 손으로 누를 수 없음
            answer = "NO";
        }else{
            int sum = 0;

            for (int i = 0; i < push.size(); i++) {
                for (int j = 0; j < push.get(i).length(); j++) {
                    int n = Integer.parseInt(String.valueOf(push.get(i).charAt(j)));
                    sum += n;
                }
            }

            if(sum == cntOne){
                answer = "YES";
            }
        }

        return answer;
    }
}
