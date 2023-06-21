package 강의내용.알고리즘.이진탐색.연습문제;

// Practice1
// 이진 탐색 추가 구현
// target 값이 arr 내에 있으면 해당 인덱스 반환
// 없으면 해당 값이 있을 경우의 위치에 -1을 곱하고 1을 뺀 값을 반환

// 입출력 예시
// 입력 arr : 1, 2, 5, 10, 20, 30, 40, 50, 60

// target : 30
// 출력 : 5

// target : 3
// 출력 : -3

public class Practice1 {

    public static int solution(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left<=right){
            int mid = (left + right) / 2; // 두 값을 더하면서 overflow가 발생할 수 있다.
            // 오버플로우가 발생할 수 있다.
            // int mid = left + (right - left) / 2; overflow가 날 것 같은 경우 방지

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return (left + 1) * -1; // 실패하는 경우
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = new int[]{1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(solution(arr,30)); // 5
        System.out.println(solution(arr,3)); // -3
        System.out.println(solution(arr,11)); // -5
        System.out.println(solution(arr,35)); // -7
    }
}
