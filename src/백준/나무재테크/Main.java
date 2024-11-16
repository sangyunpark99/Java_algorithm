package 백준.나무재테크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int k;
    public static ArrayList<ArrayList<ArrayList<Tree>>> map = new ArrayList<>();
    public static int[][] A;
    public static int[][] yangbun;
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        A = new int[n][n];
        yangbun = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                yangbun[i][j] = 5;
            }
        }

        // 봄,여름,가을,겨울
        for (int i = 0; i < n; i++) {
            A[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            ArrayList<ArrayList<Tree>> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(new ArrayList<>()); // 각 셀에 1차원 리스트(Tree 리스트) 추가
            }
            map.add(row); // 2차원 리스트를 바깥 리스트에 추가
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            Tree tree = new Tree(y, x, Integer.parseInt(st.nextToken()));
            map.get(y).get(x).add(tree);
        }

        for (int i = 0; i < k; i++) {
            springSummer();
            fall();
            winter();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += map.get(i).get(j).size();
            }
        }

        System.out.println(answer);
    }

    public static class Tree {
        int y;
        int x;
        int z;

        public Tree(int y, int x, int z) {
            this.y = y;
            this.x = x;
            this.z = z;
        }
    }

    public static void springSummer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map.get(i).get(j).size() == 0) {
                    continue;
                }
                // 여러개가 존재하는 경우
                ArrayList<Tree> copyTrees = map.get(i).get(j);
                ArrayList<Tree> temp = new ArrayList<>();
                Collections.sort(copyTrees, new Comparator<Tree>() {
                    @Override
                    public int compare(Tree o1, Tree o2) {
                        return o1.z - o2.z;
                    }
                });

                int dieTree = 0;
                for (Tree tree : copyTrees) {
                    if (yangbun[i][j] >= tree.z) {
                        yangbun[i][j] -= tree.z;
                        tree.z += 1;
                        temp.add(tree);
                    } else { // 죽는 경우
                        dieTree += tree.z / 2; // 죽을때 양분
                    }
                }

                map.get(i).get(j).clear();
                map.get(i).get(j).addAll(temp); // 교체
                yangbun[i][j] += dieTree;
            }
        }
    }

    public static void fall() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map.get(i).get(j).size() == 0) {
                    continue;
                }
                for (Tree tree : map.get(i).get(j)) {
                    if (tree.z % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int ny = i + dy[d];
                            int nx = j + dx[d];
                            if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                                continue;
                            }
                            map.get(ny).get(nx).add(new Tree(ny, nx, 1));
                        }
                    }
                }
            }
        }
    }

    public static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                yangbun[i][j] += A[i][j];
            }
        }
    }
}