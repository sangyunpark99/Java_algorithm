package pre코딩테스트연습.three_four.five;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1,0,0,0,0,1}, 2));
    }

    public boolean solution(int[] bridge, int jumpSize) {
        boolean answer = true;

        // 0의 갯수
        int zeroNum = 0;
        // 1만날때마다 확인
        for (int i = 0; i < bridge.length; i++) {
            if(bridge[i] == 1){
                if(zeroNum > jumpSize){
                    return false;
                }else{
                    zeroNum = 0;
                }
            }else{
                zeroNum++;
            }
        }


        return answer;
    }
}
