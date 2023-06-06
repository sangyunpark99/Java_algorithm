package 강의연습문제.기초수학.practice7;

public class Practice7 {

    public static int solution(String str){
        return isPalindrome(0, str.length()-1, str.toCharArray(), 0);
    }

    public static int isPalindrome(int left, int right, char[] arr, int delCnt){

        while(left < right){
            if(arr[left] != arr[right]){ // 왼쪽 기준 값과 오른쪽 기준 값이 같지 않은 경우
                if(delCnt == 0){ // 아직 하나도 지우지 않은 경우
                    if(isPalindrome(left+1, right, arr, 1) == 0 || isPalindrome(left, right-1, arr, 1) == 0){ // 유사회문
                        return 1;
                    } else {
                        return 2;
                    }
                } else { // 이미 하나를 지웠는데도 팰린드롬이 만족되지 않는 경우
                    return 2;
                }
            } else { // 같은 경우 다음 차례를 비교하기
                left++;
                right--;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("abba"));
        System.out.println(solution("summuus"));
    }
}
