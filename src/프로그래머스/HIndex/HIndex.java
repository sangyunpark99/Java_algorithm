package 프로그래머스.HIndex;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        Arrays.sort(citations);

        System.out.println(Arrays.stream(citations).boxed().collect(Collectors.toList()));
    }
}
