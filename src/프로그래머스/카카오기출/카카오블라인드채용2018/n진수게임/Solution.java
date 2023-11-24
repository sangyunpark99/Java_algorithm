package 프로그래머스.카카오기출.카카오블라인드채용2018.n진수게임;

class Solution {

    // 1번째 사람 - 0 ,... 10번째 사람 - 9
    // 10이상의 숫자 한자리씩 끊어서, 11번째사람 1, 12번째 사람 0

    // 진법 변환
    // 변환한 모든 진법 합치기
    // 순서에 맞게 단어 choice

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder con = new StringBuilder();

        for (int i = 0; i <= m * t; i++) {
            con.append(Integer.toString(i, n));
        }

        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(con.charAt(i));
        }

        return answer.toString().toUpperCase();
    }
}