package 강의연습문제.기초수학.practice8;

// 주어진 1차 방정식에 대해 풀이를 하는 프로그램을 작성하세요.
// 해당 방정식은 '+', '-', 'x'와 상수로만 이루어져 있다.
// 해가 없으면 "No action"을 출력,
// 해가 무한대인 경우 "Infinite solutions"를 출력.
// 해가 있는 경우 x의 값을 "x="형태로 출력

public class Practice8 {

    public static String solution(String str){

        // split 사용하기
        String[] parts =str.split("=");
        int[] leftPart = evaluate(parts[0]);
        int[] rightPart = evaluate(parts[1]);

        if(leftPart[0] == rightPart[0] && leftPart[1] == rightPart[1]){
            // x == x
            // 0 == 0
            return "infinite solutions";
        }else if (leftPart[0] == rightPart[0]){ // x = x + 1과 같은 상황
            return "No solution";
        }else {
            return "x=" + (rightPart[1] - leftPart[1] / (leftPart[0] - rightPart[0]));
        }
    }

    public static int[] evaluate(String str){
        int[] result = new int[2]; //x의 개수, 상수항

        boolean isMinus = false;
        int idx = 0;
        while(idx!= str.length()){

            char c = str.charAt(idx++);

            if(c == '+'){
                continue;
            }

            if(c == '-'){
                isMinus = true;
                continue;
            }

            if(c == 'x'){
                result[0] += isMinus ? -1 : 1;
            }else {
                int same = isMinus ? -(c - '0') : (c - '0');
                if(idx < str.length() && str.charAt(idx) == 'x'){ // index 에러 방지 + 2x, 3x 이런 꼴도 고려
                    result[0] += same; // 음수인지 아닌지 판별
                } else {
                    result[1] += same;
                }
            }
            isMinus = false;
        }

        return result;
    }

    public static int[] evaluate2(String str){
        int[] result = new int[2];

        for (String s : str.split("(?=[+-])")) {
            if(s.equals("+x") || s.equals("x")){
                result[0]++;
            }else if(s.equals("-x")){
                result[0]--;
            }else if(s.contains("x")){
                result[0] += Integer.parseInt(s.substring(0,s.length()-1));
            }else {
                result[1] += Integer.parseInt(s);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("x+5-3+x=6+x-2"));
    }
}
