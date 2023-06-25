package pre코딩테스트연습.one_three.four;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("-3+2-6-7"));
    }

    public static int solution(String s) {

        int answer = 0;

        s += "+";

        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();

        String num = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '-' ){
                a.add("-");
                if(num.length() > 0){
                    b.add(num);
                    num = "";
                }
            }else if(s.charAt(i) == '+'){
                a.add("+");
                if(num.length() > 0){
                    b.add(num);
                    num = "";
                }
            }else{
                    num += s.charAt(i);
            }
        }

        a.remove(a.size()-1);

        for (int i = 0; i < a.size(); i++) {
            if(a.get(i).equals("-")){
                answer -= Integer.valueOf(b.get(i));
            }else{
                answer += Integer.valueOf(b.get(i));
            }
        }

        return answer;
    }
}
