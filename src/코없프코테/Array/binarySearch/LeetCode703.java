package 코없프코테.Array.binarySearch;

public class LeetCode703 {
    public int search(int[] nums, int target) { // 이진 탐색으로 logn 시간복잡도로 값을 찾아낸다.
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }
}
