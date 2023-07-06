package 큰돌의터전알고리즘강의.two주차.오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 짝짓기 문제
// Stack 생각
// 90%정도!
public class Main {

    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());

        arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        int[] ret = new int[1000004];

        Arrays.fill(ret,-1);

        for (int i = 1; i < arr.length; i++) {

            while(stack.size()>0 && stack.peek() < arr[i]){ // 0보다
                ret[stack.pop()] = arr[i]; // 빼주고
            }

            stack.push(arr[i]);
        }

        for (int i = 1; i < arr.length; i++) {
            sb.append(ret[arr[i]]);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
