    import java.io.*;
    import java.util.*;
    
    // 불이 하나가 아닌 여러개일 수 있다.
    public class Main {
    
        public static int R,C,sy,sx;
    
        public static String[][] map;
    
        public static int[][] visitedFire;
        public static int[][] visitedHuman;
    
        public static int[] dx;
        public static int[] dy;
    
        public static Node fireLocation;
        public static Node humanLocation;
    
        public static Queue<Node> fireQueue;
    
        public static int res = 0;
    
        // 불이 존재하지 않을때의 반례가 존재한다.
        public static void main(String[] args) throws IOException {
    
            // 초기화
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
    
            map = new String[R][C];
    
            // 0으로 초기화
            visitedFire = new int[R][C];
            visitedHuman = new int[R][C];
    
            for (int i = 0; i < R; i++) {
                Arrays.fill(visitedFire[i],Integer.MAX_VALUE); // 불이 없는 경우를 방지
            }
    
            dx = new int[]{0,1,0,-1};
            dy = new int[]{-1,0,1,0};
    
            fireQueue = new LinkedList<>();
    
            // 맵 입력
            for (int i = 0; i < R; i++) {
                String S = br.readLine();
                for (int j = 0; j < C; j++) { // 불 좌표, 지훈이 좌표 찾기
                    map[i][j] = String.valueOf(S.charAt(j));
                    if(map[i][j].equals("J")){
                        sy = i;
                        sx = j;
                    }else if(map[i][j].equals("F")){ // 불이 여러개, 불이 아무것도 없을 수 있다. -> 반레
                        fireQueue.add(new Node(j,i));
                        visitedFire[i][j] = 1;
                    }
                }
            }
    
            // (1) 불이 이동할 수 있는 최단경로
            fireBfs();
    
            // (2) 사람이 이동할 수 있는 최단경로 + 길 비교해야함
            humanBfs();
            // 가능한 길 찾아서
    
    
            if(res !=0){
                System.out.println(res);
            }else{
                System.out.println("IMPOSSIBLE");
            }
        }
    
        public static void humanBfs(){
    
            visitedHuman[sy][sx] = 1;
    
            Node node = new Node(sx,sy);
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
    
            while(queue.size()>0){
                Node cur = queue.poll();
    
                int cx = cur.x;
                int cy = cur.y;
    
                if(cx == C-1 || cy == R-1 || cx == 0 || cy == 0){ // 가장자리인 경우 탈출
                    res = visitedHuman[cy][cx];
                    break;
                }
    
                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
    
                    if(!isIn(nx,ny)) continue;
                    if(visitedHuman[ny][nx] > 0 || map[ny][nx].equals("#")) continue;
                    if(visitedFire[ny][nx] <= visitedHuman[cy][cx]+1) continue;
                    visitedHuman[ny][nx] = visitedHuman[cy][cx] + 1;
                    queue.add(new Node(nx,ny));
                }
            }
        }
    
        public static void fireBfs(){
    
            while(fireQueue.size()>0){
                Node cur = fireQueue.poll();
                int cx = cur.x;
                int cy = cur.y;
    
                for (int i = 0; i < 4; i++) { // 4방향 탐지
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
    
                    if(!isIn(nx,ny)) continue;
                    if(visitedFire[ny][nx] != Integer.MAX_VALUE || map[ny][nx].equals("#")) continue;
                    visitedFire[ny][nx] = visitedFire[cy][cx] + 1;
                    fireQueue.add(new Node(nx,ny));
                }
            }
        }
    
    
        public static class Node {
            int x;
            int y;
    
            Node(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
    
        public static boolean isIn(int nx, int ny){
            return nx >= 0 && nx < C && ny >= 0 && ny < R;
        }
    }