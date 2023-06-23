package 코없프코테.Array.MergeSortedArray;

public class LeetCode88 {

    public static void main(String[] args) {
        merge(new int[] {1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Idx = m - 1;
        int nums2Idx = n - 1;
        int wIdx = nums1.length - 1;

        if(nums2Idx < 0){
            return;
        }

        while(0 <= nums1Idx && 0 <= nums2Idx){
            int num1 = nums1[nums1Idx];
            int num2 = nums2[nums2Idx];

            if(num2 <= num1){
                int num = num1;
                nums1[wIdx] = num;
                nums1Idx--;
                wIdx--;
            }else{
                int num = num2;
                nums1[wIdx] = num;
                nums2Idx--;
                wIdx--;
            }
        }

        // [4,5,6,4,5,6]
        // [1,2,3]
        // 위와 같은 경우 [1,2,3] 부분의 배열을 복사해주어야 한다.
        while(0 <= nums2Idx){ // 예외 케이스 - nums1의 값이 전부다 커서 값을 차지한 경우
            nums1[wIdx] = nums2[nums2Idx];
            nums2Idx--;
            wIdx--;
        }
    }
}
