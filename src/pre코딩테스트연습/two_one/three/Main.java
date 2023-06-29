package pre코딩테스트연습.two_one.three;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().solution(
                "가나가나",
                "드래곤 마음 드래곤 마음"));
    }

    public boolean solution(String p, String s) {
        boolean answer = true;

        String[] ans = s.split(" ");

        if (ans.length % 4 !=0){ // 4자리씩 컷하지 않게된다면
            answer = false;
            return answer;
        }

        HashMap<String,String> pToS = new HashMap<>();

        for (int i = 0; i < p.length(); i++) { // 다름을 비교
            String ps = String.valueOf(p.charAt(i));
            if(pToS.containsKey(ps)){ // 존재한다면
                if(!pToS.get(ps).equals(ans[i])){ // 존재하는 값이랑 현재 값이란 다른 경우
                    answer = false;
                    break;
                }
            }else{ // 존재하지 않는다면
                if(pToS.containsValue(ans[i])){ // 값이 이미 사용된 경우
                    return false;
                }else{ // 그렇지 않은 경우
                    pToS.put(String.valueOf(p.charAt(i)),ans[i]); // 값 추가
                }
            }
        }

        return answer;
    }
}
