package 코없프코테.HashMap.FindFirstUniqueCharacter;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s){
        LinkedHashMap<String, Integer> words = new LinkedHashMap<>();

        // String은 length()
        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            words.put(key,words.getOrDefault(key,0) + 1);
        }

        String find = "";

        // 갯수가 1개인 원소를 찾는다.
        for(Map.Entry<String, Integer> elem : words.entrySet()){
            if(elem.getValue() == 1){
                find = elem.getKey();
                return s.indexOf(find);
            }
        }

        return -1;
    }
}
