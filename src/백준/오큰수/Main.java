package 백준.오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static int N;
    public static int[] A;
    public static int[] ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ret = new int[N];

        Arrays.fill(ret, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                int index = stack.pop();
                ret[index] = A[i];
            }

            stack.push(i); // 넣고
        }

        StringBuilder sb = new StringBuilder();

        for (int value : ret) {
            sb.append(value + " ");
        }

        System.out.println(sb);
    }
}
