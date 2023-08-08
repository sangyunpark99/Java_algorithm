package 프로그래머스.타겟넘버;

public class Solution {

    static int answer = 0;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1,1,1,1,1}, 3));
    }

    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target);

        return answer;
    }

    public static void dfs(int sum, int idx, int[] numbers, int target){ // 변수값 저장하기

        if(idx == numbers.length){
            if(sum == target){
                answer++;
            }

            return;
        }

        dfs(sum + numbers[idx], idx+1, numbers, target);
        dfs(sum - numbers[idx], idx+1, numbers, target);
    }
}
