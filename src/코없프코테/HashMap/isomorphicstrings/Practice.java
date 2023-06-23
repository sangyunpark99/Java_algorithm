package 코없프코테.HashMap.isomorphicstrings;

import java.util.HashMap;

public class Practice {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"aaaffh","xyzhhh"}));
    }
    
    public static boolean solution(String[] arr){
        
        HashMap<Character, Character> map = new HashMap<>();

        String first = arr[0];
        String second = arr[1];

        for (int i = 0; i < first.length(); i++) {

            if(!map.containsKey(first.charAt(i))) { // 값이 존재하지 않는 경우
                map.put(first.charAt(i), second.charAt(i));
            }else{
                if(!map.get(first.charAt(i)).equals(second.charAt(i))){
                    return false;
                }
            }
        }

        return true;
    }
}
