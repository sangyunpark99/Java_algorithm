package 백준.괄호복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String value = br.readLine();
            solution(value);
        }
    }

    public static void solution(String value) {
        Stack<Character> stack = new Stack<>();

        for (char a : value.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                if (a == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else if (stack.peek() == ')') {
                        break;
                    }
                } else {
                    if (stack.peek() == ')') {
                        break;
                    }
                    stack.push('(');
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }
}