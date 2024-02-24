package 백준.버블소트1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        mData[] A = new mData[N];
        for (int i = 0; i < N; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A);

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (result < A[i].index - i) { // 정렬 전 : A[i].index, 정렬 후 : i
                result = A[i].index - i;
            }
        }
        System.out.println(result + 1);
    }
}

class mData implements Comparable<mData> {

    int value;
    int index;

    public mData(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) { // value 기준 오름차순 정렬 | Array.sort를 하려면 필수적으로 존재해야함
        return this.value - o.value;
    }
}
