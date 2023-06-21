package 강의내용.알고리즘.이진탐색.개념;

// 이진 탐색
// 정렬된 상태의 데이터에서 특정 값을 빠르게 탐색하는 방법
// - 찾고자 하는 값과 데이터 중앙에 있는 값을 비교
// - 찾고자 하는 값이 더 작으면 데이터 왼쪽 부분에서 이진 탐색
// - 찾고자 하는 값이 더 크면 데이터 오른쪽 부분에서 이진 탐색
// - 알고리즘 시간 복잡도 O(logn)

public class Main {
    // 반복문 구조
    public static int binarySearch(int arr[], int target){

        int left = 0;
        int right = arr.length - 1; // 배열을 length

        while(left <= right){
            int mid = (left + right) / 2;

            if(target == arr[mid]){ // 원하는 값을 찾은 경우
                return mid;
            }else if(target < arr[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return -1;

    }

    // 재귀 호출 구조
    public static int binarySearch2(int arr[], int target, int left, int right){ // 모든 구문에 return이 있으므로 필요 x

        if(left > right){ // 못찾았음
            return -1;
        }

        int mid = (left + right) / 2;

        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            return binarySearch2(arr, target, mid+1, right);
        }else{
            return binarySearch2(arr, target, left, mid-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,10,20,30,40,50,60};

        System.out.println("Index : " + binarySearch(arr,30));

        System.out.println("Index : " + binarySearch2(arr,30,0,arr.length-1));
    }
}
