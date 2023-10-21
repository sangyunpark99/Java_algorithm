package 큰돌의터전알고리즘강의.five주차.멀티탭스케줄링;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        boolean[] use = new boolean[101];

        int put = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < k; i++) {
            int order = arr[i];

            if(!use[order]){ // 사용중이 아니라면
                if(put < n){ // 공간이 있다면
                    use[order] = true;
                    put++;
                }else{ // 공간이 없다면

                    // 어떤걸 제거할까? -> 어떤게 사용될까?
                    ArrayList<Integer> list = new ArrayList<>(); // 사용되는 리스트

                    for (int j = i+1; j < k; j++) {
                        if(use[arr[j]] && !list.contains(arr[j])){
                            list.add(arr[j]);
                        }
                    }

                    if(list.size() < n){ // 나중에 사용되는 수가 더 작은 경우
                        // 사용되지 않은 수 제거
                        for (int j = 0; j < use.length; j++) {
                            if(use[j] && !list.contains(j)){
                                use[j] = false;
                                break;
                            }
                        }
                    }else{ //
                        use[list.get(list.size()-1)] = false;
                    }

                    answer++;
                    use[order] = true;

                }
            }
        }

        System.out.println(answer);
    }
}
