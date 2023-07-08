package pre코딩테스트연습.three_two.three;

public class Solution {
    public String solution(int[] arr, String prefix, String separator, String postfix) {
        StringBuilder sb = new StringBuilder();

        sb.append(prefix);

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if(i == arr.length-1){
                continue;
            }
            sb.append(separator);
        }

        sb.deleteCharAt(sb.length()-1);

        sb.append(postfix);

        return sb.toString();
    }
}
