package 강의내용.알고리즘.이진탐색.개념;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {

        // 항상 정렬이 되어 있어야 한다.

        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("== 데이터가 있는 경우==");
        System.out.println(Arrays.binarySearch(arr,1));
        System.out.println(Arrays.binarySearch(arr,10));
        System.out.println(Arrays.binarySearch(arr,30));

        System.out.println("== 데이터가 없는 경우==");
        // 지정된 배열에서 존재할 위치 + 1의 부호를 반전한 값을 출력해준다
        // ex) 3 -> arr 배열에서 index 2번에 위치해야 함 -> 2 + 1 의 부호반전 -3이 출력된다.
        System.out.println(Arrays.binarySearch(arr, 3)); // 부호 반전 후 1을빼서 해당 위치에 삽입이 가능하다.
        System.out.println(Arrays.binarySearch(arr, 11));
        System.out.println(Arrays.binarySearch(arr, 35));
    }
}
