package 프로그래머스.풍선터트리기;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, -1, -5}));
        System.out.println(solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }

    public static int solution(int[] a) {
        int answer = 0;

        // 각 인덱스별 왼쪽 기준 최솟값
        int[] minLeft = new int[a.length];
        int minLeftValue = a[0];

        for (int i = 0; i < a.length; i++) { // O(n) 1,000,000
            if (minLeftValue > a[i]) {
                minLeftValue = a[i];
            }

            minLeft[i] = minLeftValue;
        }

        // 오른쪽기준 최솟값
        int[] minRight = new int[a.length];
        int minRightValue = a[a.length - 1];

        for (int i = a.length - 1; i >= 0; i--) { // O(n) 1,000,000
            if (minRightValue > a[i]) {
                minRightValue = a[i];
            }

            minRight[i] = minRightValue;
        }

        // 최솟값을 기준
        for (int i = 0; i < a.length; i++) { // O(n) 1,000,000
            int value = a[i];
            if (minLeft[i] == value || minRight[i] == value) {
                // 주어진 수가 왼쪽 최솟값과 같고, 오른쪽 최솟값보다 작아도 한번 제거할 수 있다.
                answer++;
            }
        }

        return answer;

        // O(n) = 3,000,000
    }
}