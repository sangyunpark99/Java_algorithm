package pre코딩테스트연습.one_two.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class practice {

    public static void main(String[] args) {
        System.out.println(solution(5,"Snowball",15));
    }

    public static String solution(int n, String s, int t){

        String answer = "";

        Queue<String> queue = new LinkedList<>();

        ArrayList<String> list = new ArrayList<String>();

         // 초기화
        for (int i = 0; i < n; i++) {
            list.add(".");
        }

        for (int i = 0; i < s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
        }

        // 초기화
        for (int i = 0; i < n; i++) {
            queue.add(list.get(i));
        }

        int k = n;

        if(t!=0){
            for (int i = 1; i <= t; i++) {

                if(k > list.size() - 1 ){
                    k = 0;
                }

                queue.remove();
                queue.add(list.get(k));
                k++;
            }
        }

        queue.toArray();

        String[] answerList = queue.toArray(new String[]{});

        for (int i = 0; i < queue.size(); i++) {
            answer += answerList[i];
        }

        return answer;
    }
}
