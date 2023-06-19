package 백준.통나무건너뛰기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// greedy - 가장 작은 것을 양끝으로 점점 커지는 숫자를 넣어준다.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer[] numbers = new Integer[n];

            int index = 0;
            while(st.hasMoreTokens()){
                numbers[index] = Integer.parseInt(st.nextToken());
                index++;
            }

            solution(numbers,n);
        }
    }

    public static void solution(Integer[] nums, int n){
        int answer = 0;

        Deque<Integer> dq = new LinkedList<Integer>();

        // Integer만 가능함
        Arrays.sort(nums, Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            if(i%2 == 0){
                dq.addFirst(nums[i]);
            }else{
                dq.addLast(nums[i]);
            }
        }

        // 마지막에 넣어주기때문에 밑에 for문에서 deque.size를 해주면 안됨 -> 1개 더 존재함
        dq.addLast(dq.getFirst()); // 원형이므로 처음이랑 마지막 값을 빼주는 것도 고려해야한다.

        // 최소 난이도 : 난이도가 제일 높은거
        for (int i = 0; i < n; i++) {
            int a = dq.removeFirst();
            int b = dq.removeFirst();

            answer = Math.max(Math.abs(a-b),answer);
            dq.addFirst(b); // 빼준걸 다시 넣어주어야 한다.
        }

        System.out.println(answer);
    }
}
