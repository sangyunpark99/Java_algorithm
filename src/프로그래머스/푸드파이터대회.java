package 프로그래머스;

public class 푸드파이터대회 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,4,6}));
    }

    public static String solution(int[]food){
        String answer = "";
        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i]/2; j++){
                answer += i;
            }
        }

        answer += '0' + reverse(answer);

        return answer;
    }

    public static String reverse(String a){
        String answer = "";
        for(int i = a.length()-1; i > -1; i--){
            answer += a.charAt(i);
        }
        return answer;
    }
}
