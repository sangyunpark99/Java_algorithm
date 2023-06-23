package 코없프코테.HashMap.wordpattern;

import java.util.HashMap;

public class Practice {
    public static void main(String[] args) {
        System.out.println(solution("abba", "banana apple apple banana"));
        System.out.println(solution("acc", "kiwi grape apple"));
        System.out.println(solution("abba", "dog dog dog dog"));
    }

    public static boolean solution(String pattern, String s){

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        String[] b = s.split(" ");

        if(pattern.length() != b.length) return false; // 크기가 같지 않은 경우 return false 해준다.

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = b[i];

            if(map.get(c) == null){ // 값을 갖고 있지 않은 경우
                if(map2.containsKey(str)){ // 하지만 map2에서는 갖고있는 경우 - 다른 값이 입력되었다.
                    return false;
                }else{
                    map.put(c,str);
                    map2.put(str,c);
                }
            }else{ // 값을 갖고 있는 경우
                if(!map.get(c).equals(str)){
                    return false;
                }
            }
        }

        return true;
    }
}
