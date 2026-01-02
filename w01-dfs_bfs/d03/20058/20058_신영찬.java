import java.util.*;
import java.io.*;

class Main {
    static int n, q, size;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        //비트 연산으로 pow 대체
        size = (1 << n);
        map = new int[size][size];

        //map 초기화
        for(int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //L(파이어스톰 시전) 반복
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int L = Integer.parseInt(st.nextToken());
            //L이 0인 경우도 있음. 이 경우 격자 분리 및 roatate 불필요
            if(L > 0) {
                map = divide(L);
            }
            map = melt();
        }
        printAnswer();
    }
    
    //TODO : 격자 나누기
    static int[][] divide(int L) {
        int[][] dividedMap = new int[size][size];
        int subsize = (1 << L); //위와 동일하게 pow 대체하는 비트 연산

        //subsize만큼씩 건너뛰며(구획화) rotate 진행
        for (int i = 0; i < size; i += subsize) {
            for (int j = 0; j < size; j += subsize) {
                rotate(i, j, subsize, dividedMap);
            }
        }
        return dividedMap;
    }
        
    //TODO : 시계방향 돌리기
    static void rotate(int r, int c, int subsize, int[][] dividedMap) {
        for(int i = 0; i < subsize; i++) {
            for (int j = 0; j < subsize; j++) {
                //L = 1 : (0, 0) -> (0, 1), (0, 1) -> (1, 1), (1, 0) -> (0, 0), (1, 1) -> (0, 1)
                //L = 2 : (0, 0) -> (0, 3), (0, 1) -> (1, 3), (0, 3) -> (3, 3), (3, 0) -> (0, 3)
                //map[r + i][c + j] -> 격자 안에서 현재 위치
                //subsize - 1 - i
                dividedMap[r + j][c + subsize - 1 - i] = map[r + i][c + j];
            }
        }
    }
    
    //TODO : 얼음 줄이기
    static int[][] melt() {
        //녹는걸 바로 반영하면 안 되므로 복사해서 임시 map 생성
        int[][] meltingMap = new int[size][size];
        for (int i = 0 ; i < size; i++) meltingMap[i] = map[i].clone();

        int iceCount = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 0) continue; //이미 녹았을 경우
                
                iceCount = 0;
                for(int k = 0; k < 4; k++) {
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];
                    if (nextX >= 0
                        && nextX < size
                        && nextY >= 0
                        && nextY < size
                        && map[nextX][nextY] > 0) {
                        iceCount++;
                        }
                }
                if (iceCount < 3 && meltingMap[i][j] > 0) meltingMap[i][j]--;  
            }
        }
        return meltingMap;
    }
    
    //TODO : 얼음 합 구하면서 BFS 돌리기
    static void printAnswer() {
        int iceCount = 0;
        int maxIceSize = 0;
        boolean[][] visited = new boolean[size][size];
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                iceCount += map[i][j]; //도는 겸사겸사 얼음 합 구하기

                if(!visited[i][j] && map[i][j] > 0) {
                    int currentIceSize = 0;
                    deque.addLast(new int[] {i, j});
                    visited[i][j] = true;

                    while (!deque.isEmpty()) {
                        int[] currNode = deque.removeFirst();
                        currentIceSize++;

                        for (int k = 0; k < 4; k++) {
                            int nextX = currNode[0] + dx[k];
                            int nextY = currNode[1] + dy[k];

                            if(nextX >= 0
                               && nextX < size
                               && nextY >= 0
                               && nextY < size
                               && !visited[nextX][nextY]
                               && map[nextX][nextY] > 0) {
                                visited[nextX][nextY] = true;
                                deque.addLast(new int[] {nextX, nextY});
                               }
                        }                
                    }
                    maxIceSize = Math.max(maxIceSize, currentIceSize);
                }
            }
        }
        System.out.println(iceCount);
        System.out.print(maxIceSize);
    }
}