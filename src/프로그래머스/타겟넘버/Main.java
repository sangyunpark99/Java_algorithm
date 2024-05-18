package 프로그래머스.타겟넘버;

public class Main {

    public static int answer;

    public static void main(String[] args) {
        dfs(new int[]{1, 1, 1, 1, 1}, 3, 0, 0);
    }

    public static void dfs(int[] numbers, int target, int sum, int here) { // 빼거나 더하거나

        System.out.println("sum = " + sum);

        if (here == numbers.length - 1) {
            if (sum == target) {
                answer++;
                return;
            }
            return;
        }

        dfs(numbers, target, sum + numbers[here], here + 1);
        dfs(numbers, target, sum - numbers[here], here + 1);
    }
}
