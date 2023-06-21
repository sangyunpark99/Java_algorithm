package 강의내용.알고리즘.투포인터.개념;

// 배열에서 두 개의 포인터를 사용해서 원하는 결과를 얻는 방법
// 두 개 포인터의 배치 방법
// - 같은 방향에서 시작 : 첫 번째 원소에 둘 다 배치
// - 서로 다른 방햐에서의 시작 : 첫 번째 원소와 마지막 원소에 배치
// 다중 for문의 복잡도를 좀 더 선형적으로 풀 수 있음
// 알고리즘 시간 복잡도 : O(n)


import java.util.Arrays;

public class Main {

    public static int[] forLoop(int[] arr, int target){

        int[] result = {-1, -1};

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i+1; j < arr.length; j++) { // i가 마지막 원소면 j에서 어차피 걸려서 안됨

                if(sum == target){
                    result[0] = i;
                    result[1] = j - 1;
                    break;
                }
                sum += arr[j];
            }

            if(sum == target){ // 반복문 완전 탈출하기
                break;
            }
        }

        return result;
    }

    public static int[] twoPointers(int[] arr, int target){ // 같은 위치에 분포
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int[] result = {-1, -1};

        while(true){
            if(sum > target){
                sum -= arr[p1++]; // 기존의 값을 빼고 p1 ++ 해주기
            }else if(p2 == arr.length){ // 끝까지 간경우
                break;
            }else{
                sum += arr[p2++];
            }

            if(sum == target){ // 값을 찾은 경우
                result[0] = p1;
                result[1] = p2 - 1; // 항상 마지막 다음 요소를 가리키므로 1을 빼주어야 한다.
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 2, 4, 3, 2};

        System.out.println(Arrays.toString(forLoop(arr, 9)));
        System.out.println(Arrays.toString(forLoop(arr, 14)));
        System.out.println();

        System.out.println(Arrays.toString(twoPointers(arr, 9)));
        System.out.println(Arrays.toString(twoPointers(arr, 14)));
    }
}
