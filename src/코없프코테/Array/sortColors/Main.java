package 코없프코테.Array.sortColors;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // 시간 복잡도 O(n)

        int[] nums = new int[]{1,0,2,2,0,1,2,1,0};
        
        int idx0 = 0; // 0을 담을 인덱스
        int idx2 = nums.length - 1; // 2를 담을 인덱스

        int i = 0;

        while(i <= idx2){ // idx2를 만나게 되면 전부 다 정렬이 됨을 알 수 있다.
            if(nums[i] == 0){ // 0인 경우
                swap(nums, i, idx0);
                idx0++;
                i++;
            }else if(nums[i] == 2){ // 2인 경우
                swap(nums,i,idx2);
                idx2--;
                // i++을 해주지 않는 이유 : 바꾼숫자가 1인경우 0이랑 다시 바꿔주어야 한다.
            }else{ // 1인 경우
                i++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums,int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
