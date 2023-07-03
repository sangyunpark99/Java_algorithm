package pre코딩테스트연습.two_five.five;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{0,20,22,17}));
    }

    public String solution(int[] arr) {
        String answer = "YES";

        for (int i = 1; i < arr.length; i++) {
            if(i*2 >= arr.length || i*2+1 >= arr.length) break;
            if(arr[i*2] < arr[i] || arr[i*2+1] < arr[i]){
                answer = "NO";
            }
        }
        
        return answer;
    }
}
