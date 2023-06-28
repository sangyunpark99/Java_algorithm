    package 큰돌의터전알고리즘강의.one주차.패션왕신해빈;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.HashMap;
    import java.util.StringTokenizer;

    public class Main {
        // 아무것도 안입은 경우의 수 추가 - 넣는 경우, 안넣는 경우 다 곱하고 - 1해주면 된다.
        // 경우의 수인 경우 long으로 박고 시작하라!
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int testCase = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < testCase; i++) { // 각 테스트 케이스
                int num = Integer.parseInt(br.readLine());
                for (int j = 0; j < num; j++) { // 입력받은 수만큼 행진!
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    String name = st.nextToken(); // 이름
                    String type = st.nextToken(); // 유형

                    map.put(type, map.getOrDefault(type,1)+1); // 아무것도 안입은 경우
                }

                int answer = 1;

                for (Integer value : map.values()) {
                    answer*=value;
                }
                System.out.println(answer-1); // 아무것도 안입은 경우의 수 빼주기
                map.clear();
            }
        }
    }
