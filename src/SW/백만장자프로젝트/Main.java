package SW.백만장자프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = null;

        int profit = 0;

        t = Integer.parseInt(br.readLine());

        // 제일 큰 값을 찾아서, 작은 값들을 팔면

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            List<Integer> values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(
                    Collectors.toList());

            List<Integer> sortedValues = new ArrayList<>(values);
            sortedValues.sort(Collections.reverseOrder());
            int idx = 0;
            for (int j = 0; j < values.size(); j++) {
                if (values.get(j) < sortedValues.get(idx)) {
                    profit += sortedValues.get(idx) - values.get(j);
                } else if (values.get(j) == sortedValues.get(idx)) {
                    if (sortedValues.size() - 1 >= idx) {
                        idx++;
                    }
                }
            }
            System.out.printf("#%d %d\n", i + 1, profit);
            profit = 0; // 초기화
        }
    }
}
