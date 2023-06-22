package pre코딩테스트연습.one_two.three;

import java.util.ArrayList;
import java.util.Arrays;

public class practice {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6,12,4}));
    }

    public static int solution(int[] A){

        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(A);

        for (int i = 1; i <= A[A.length-1]; i++) {
            int flag = 0;
            for (int j = 0; j < A.length; j++) {
                if(A[j] % i == 0){
                    flag += 1;
                }
            }

            if(flag == A.length){
                list.add(i);
            }
        }

        return list.get(list.size()-1);
    }
}
