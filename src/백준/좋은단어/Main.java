package 백준.좋은단어;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static int N;
    public static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int ret = 0;

        for (int i = 0; i < N; i++) {
            String value = br.readLine();
            stack = new Stack<>();

            for (char a : value.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(a);
                } else {
                    if (stack.peek() == a) {
                        stack.pop();
                    } else {
                        stack.push(a);
                    }
                }
            }

            if (stack.isEmpty()) {
                ret++;
            }
        }

        bw.write(ret + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}