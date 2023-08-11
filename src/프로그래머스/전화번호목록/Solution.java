package 프로그래머스.전화번호목록;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"123", "1005", "1006", "1007"}));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i = 0; i < phone_book.length; i++){
            int flag = 0;
            for(int j = i+1; j < phone_book.length; j++){
                if(phone_book[j].startsWith(phone_book[i])){
                    answer = false;
                    flag = 1;
                    break;
                }
            }

            if(flag == 1){
                break;
            }
        }

        return answer;
    }
}
