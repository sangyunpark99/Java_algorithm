package 프로그래머스;

public class 크기가작은부분문자열 {

    public static void main(String[] args) {
       int answer = solution("3141592", "271");
        System.out.println(answer);
    }

    public static int solution(String t, String p) {
        int answer = 0;
        Long nump = Long.parseLong(p);

        for(int i = 0; i < t.length() - p.length() + 1; i ++){

            Long subt = Long.parseLong(t.substring(i,i+p.length())); // 추출

            if(subt <= nump){ // 조건 만족 하는 경우
                answer += 1;
            }

        }

        return answer;
    }
}
