package pre코딩테스트연습.one_two.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class practice {

    public static void main(String[] args) {
        solution("H ELLO");
    }

    public static String[] solution(String s) {
        ArrayList<String> answer = new ArrayList<>();

        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == '.' || item == ',' || item == '!' || item == '?'|| item == ' '){
                if(!stack.isEmpty()){
                    String word = "";
                    int length = stack.size();
                    for (int j = 0; j < length; j++) {
                        word += stack.pop();
                    }
                    answer.add(word);
                }
            }else{ // 영어인 경우
                stack.add(item);
            }
        }

        if(!stack.isEmpty()){
            String word = "";
            int length = stack.size();
            for (int i = 0; i < length; i++) {
                word += stack.pop();
            }
            answer.add(word);
        }

        String[] realAnswer = answer.toArray(new String[]{});

        for (int i = 0; i < realAnswer.length; i++) {
            System.out.println(realAnswer[i]);
        }

        return realAnswer;
    }
}
