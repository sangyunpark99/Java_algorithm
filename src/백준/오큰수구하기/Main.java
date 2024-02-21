package 백준.오큰수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while (st.hasMoreTokens()) {
            nums[idx++] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 0번째 인덱스

        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int answer : result) {
            sb.append(answer + " ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
