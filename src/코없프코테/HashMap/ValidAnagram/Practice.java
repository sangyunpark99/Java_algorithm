package 코없프코테.HashMap.ValidAnagram;

import java.util.HashMap;

public class Practice {
    public static void main(String[] args) {
        System.out.println(isAnagram("nocodeprogram","promodernacog"));
    }

    public static boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        String first = s;
        String second = t;

        for (int i = 0; i < first.length(); i++) {
            map.put(first.charAt(i), map.getOrDefault(first.charAt(i), 0) + 1);
        }

        for (int i = 0; i < second.length(); i++) { //
            if(!map.containsKey(second.charAt(i))){
                return false;
            }
            map.put(second.charAt(i), map.get(second.charAt(i)) - 1);
        }

        for (int i = 0; i < map.size(); i++) {
            for (Integer value : map.values()) {
                if (value > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
