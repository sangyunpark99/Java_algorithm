package 백준.가장긴증가하는부분수열5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static int n;
    public static int[] num;

    public static void main(String[] args) throws IOException {
        // 최대 20억
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> list = new ArrayList<>();

        int indexArr[] = new int[n];

        list.add(Integer.MIN_VALUE); // 최솟값 넣어주기

        for (int i = 0; i < n; i++) {
            int number = num[i];
            int left = 0;
            int right = list.size() - 1;

            // 확인 하는 숫자가 수열의 마지막 수보다 큰 경우
            // 수열에 추가해준다.
            if (number > list.get(list.size() - 1)) { // list의 제일 끝에 존재 하는 수가 제일 크다.
                list.add(number);
                indexArr[i] = list.size() - 1; // 부분 수열 갯수
            } else { // 확인 하는 숫자가 수열의 마지막 수보다 작은 경우 -> 수의 범위가 너무 크므로 이분 탐색
                while (left < right) {
                    int mid = (left + right) / 2;

                    if (list.get(mid) >= number) { // number보다 수가 큰 경우
                        right = mid; // 더 작은 범위로 가져간다.
                    } else { // 그렇지 않은 경우
                        left = mid + 1; // 더 큰 범위로 가져간다.
                    }
                }

                list.set(right, number); // number로 수 교체
                indexArr[i] = right; // indexArr 수정
            }
        }

        // 최장 길이 출력
        System.out.println(list.size() - 1); // 맨 처음 값 제거

        // 역추적 경로
        Stack<Integer> stack = new Stack<>();

        int value = list.size() - 1; // 뒤에서 부터 값 추적

        for (int i = n - 1; i >= 0; i--) { // 갯수
            if (indexArr[i] == value) {
                value--;
                stack.push(num[i]);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
