package 백준.괄호;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) { // 입력받기
            String str = br.readLine();
            solution(str);
        }
    }

    public static void solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }else{
                if(stack.size() == 0){
                    System.out.println("NO");
                    return;
                }else{
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()){ // 짝을 맞춘경우
            System.out.println("YES");
        }else{ // 그렇지 않은 경우
            System.out.println("NO");
        }
    }
}
