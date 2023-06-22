package pre코딩테스트연습.one_two.four;

import java.util.ArrayList;
import java.util.Arrays;

public class practice {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3}, 1));
    }

    public static int solution(int[] orders, int n) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(orders);

        for (int i = 1; i <= 1000; i++) {
            list.add(i); // 모든 값 다 추가
        }

        for (int i = 0; i < orders.length; i++) {
            list.remove(Integer.valueOf(orders[i]));
        } // 배열에 들어있는 값 제거

        answer = list.get(n-1);

        return answer;
    }
}
