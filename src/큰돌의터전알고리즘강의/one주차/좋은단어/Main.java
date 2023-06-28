package 큰돌의터전알고리즘강의.one주차.좋은단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
     // 교차가 되면 안된다.
     // 짝짓기, 폭발 : stack

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 0; i < n; i++) { // 각 케이스
            String s = br.readLine();

            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {

                char ch = s.charAt(j);

                if(stack.size() >= 1 && stack.peek() == ch){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }

            if(stack.size() == 0){ // 좋은단어!
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
