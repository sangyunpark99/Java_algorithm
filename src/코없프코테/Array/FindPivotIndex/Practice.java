package 코없프코테.Array.FindPivotIndex;

public class Practice {
    public static void main(String[] args) {

        int windowSum = 0;
        int size = 3;
        int maxSum = Integer.MIN_VALUE;
        int[] arr = new int[]{5,7,-1,14,3,12,1,4};

        for (int i = 0; i < arr.length-size; i++) {
            windowSum += arr[i];
            if( i >= size-1){
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= arr[i-(size-1)];
            }
        }
    }
}
