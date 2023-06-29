package pre코딩테스트연습.two_one.four;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().solution("Hello world Nice world"));
    }

    public int solution(String s) {
        int answer = 0;

        String[] arr = s.split(" ");

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < arr.length;i++) {
            set.add(arr[i]);
        }

        answer = set.size();

        return answer;
    }
}
