package 강의연습문제.기초수학.practice3;

import java.util.ArrayList;

public class Practice3 {

    public static boolean solution(String s1, String s2){

        boolean[] visited = new boolean[s1.length()];
        char[] out = new char[s1.length()];
        ArrayList<String> list = new ArrayList<>();
        permutation(s1.toCharArray(), 0, s1.length(), s1.length(), visited, out, list);

        for (String s : list) {
            System.out.println(s);
            if(s2.contains(s)){
                return true;
            }
        }

        return false;
    }

    public static void permutation(char[] arr, int depth, int n, int r, boolean[] visited, char[] out, ArrayList<String> list) { // 순열
        if(depth == r){
            list.add(new String(out));
        }

        for (int i = 0; i < n; i++) {
            if(visited[i] != true){ // 방문하지 않은 경우
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth+1, n, r, visited, out, list);
                visited[i] = false;
            }
        }
    }

    public static boolean solution2(String s1, String s2){ // 카운팅 갯수
        final int ALPHABET = 26;

        if(s1.length() < s2.length()){
            return false;
        }

        int[] cnt = new int[ALPHABET];
        for (int i = 0; i <s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            cnt[s2.charAt(i) - 'a']++;

            if(i-s1.length() >= 0){
                cnt[s2.charAt(i-s1.length()) - 'a']++;
            }

            boolean isZero = true;
            for (int j = 0; j < ALPHABET; j++) {
                if(cnt[j] != 0){
                    isZero = false;
                    break;
                }
            }
            if(isZero){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "adback";

        System.out.println(solution(s1,s2));
    }
}
