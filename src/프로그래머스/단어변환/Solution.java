package 프로그래머스.단어변환;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int answer = 0;
    public static int[] visited;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        visited = new int[words.length];

        bfs(begin,words,target);

        int ans_index = -1;
        for (int i = 0; i < words.length; i++) {
            if(target.equals(words[i])){
                ans_index = i;
            }
        }

        if(ans_index == -1){
            answer = 0;
        }else{
            answer = visited[ans_index];
        }

        return answer;
    }

    // 최소 몇단계? bfs
    public void bfs(String begin, String[] words, String target){

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if(getChange(begin,words[i])){
                visited[i] = 1;
                queue.add(i);

                if(words[i] == target){
                    return;
                }

            }
        }

        while(!queue.isEmpty()){
            int cur_idx = queue.poll();

            for (int j = 0; j < words.length; j++) {
                if(getChange(words[cur_idx], words[j]) && visited[j] == 0){
                    queue.add(j);
                    visited[j] = visited[cur_idx] + 1;

                    if(words[j] == target){
                        queue = new LinkedList<>(); // 초기화
                        break;
                    }
                }
            }
        }

    }

    public boolean getChange(String word, String newWord){
        int differentNum = 0;

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != newWord.charAt(i)){
                differentNum++;
            }
        }

        return differentNum == 1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("cig","cog",new String[]{"cog", "dot", "dog", "lot", "log", "coq"}));
    }
}
