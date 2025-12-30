import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int answer = 0;

        Deque<int[]> deque = new ArrayDeque<>();

        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        int[][] chessBoard;
        boolean[][] visited;

        int testNum = Integer.parseInt(br.readLine());
        int l;

        int startX, startY;
        int dstX, dstY;

        for (int i = 0; i < testNum; i++) {
            l = Integer.parseInt(br.readLine());
            
            chessBoard = new int[l][l];
            visited = new boolean[l][l];
            
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            dstX = Integer.parseInt(st.nextToken());
            dstY = Integer.parseInt(st.nextToken());

            if (startX == dstX && startY == dstY) {
                answer = 0;
                if(i == testNum - 1) System.out.print(answer);
                else System.out.println(answer);
                continue;
            }

            //TODO : BFS로 경우 찾기
            
            //초기 x, y, 이동 횟수 deque에 추가
            deque.add(new int[]{startX, startY, 0});
            visited[startX][startY] = true;

            while(!deque.isEmpty()) {
                int[] current = deque.removeFirst();
                int currentX = current[0];
                int currentY = current[1];
                int dist = current[2];

                if (currentX == dstX && currentY == dstY) {
                    answer = dist;
                    break;
                }

                for(int j = 0; j < 8; j++) {
                    int nextX = currentX + dx[j];
                    int nextY = currentY + dy[j];

                    //체스보드 바깥을 나가면 안됨
                    if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l) {
                        if(!visited[nextX][nextY]) {
                            visited[nextX][nextY] = true;
                            deque.addLast(new int[]{nextX, nextY, dist + 1});
                        }
                    }
                }
            }
            if(i == testNum - 1) System.out.print(answer);
            else System.out.println(answer);
        }

        br.close();
    }
}