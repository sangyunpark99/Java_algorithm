package pre코딩테스트연습.two_five.one;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("", ""));
    }

    public int solution(String sentence, String word) { // 대소문자 구분
        int answer = -1;

        String[] words = sentence.split(" ");

        if(sentence.length() == 0){
            return -1;
        }

        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word)){
                answer = i;
                break;
            }
        }

        return answer;
    }
}
