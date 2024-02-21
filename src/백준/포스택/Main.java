package 백준.포스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        List<Stack> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Stack stack = new Stack();
            stack.add(0);
            list.add(stack);
        }

        boolean flag = true;
        for (int value : arr) {
            boolean check = false;
            for (Stack<Integer> stack : list) {
                if (value > stack.peek()) { // peek 값들보다 커야만 한다.
                    stack.push(value);
                    check = true;
                    break;
                }
            }

            if (!check) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
