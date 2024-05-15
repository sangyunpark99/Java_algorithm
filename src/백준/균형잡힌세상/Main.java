package 백준.균형잡힌세상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String value = br.readLine();

            if (value.equals(".")) {
                break;
            }

            check(value);
        }
    }

    public static void check(String value) {
        Stack<Character> stack = new Stack<>(); // (,)

        for (char c : value.toCharArray()) {
            if (c == '(' || c == ')') {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (c == '(') {
                        if (stack.peek() == ')') {
                            break;
                        }
                        stack.push('(');
                    } else {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                }
            } else if (c == '[' || c == ']') {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (c == '[') {
                        if (stack.peek() == ']') {
                            break;
                        }
                        stack.push('[');
                    } else {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("yes");
            return;
        }

        System.out.println("no");
    }
}
