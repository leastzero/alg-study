#include <iostream>
#include <string>
#include <algorithm>
#include <queue>
#include <stack>
#include <climits>
#define X first
#define Y second
using namespace std;
#define FIO ios::sync_with_stdio(0), cin.tie(0);
typedef long long ll;

int R, C;
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
string board[1005];
int dist[1005][1005];
int dist_J[1005][1005];
const int INF = 0x3f3f3f3f;


int main() {
    FIO;

    cin >> R >> C;
    for (int i = 0; i < R; i++) cin >> board[i];

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            dist[i][j] = -1; // 거리 테이블 초깃값 -1로
            dist_J[i][j] = -1;
        }
    }

    queue<pair<int, int>> Q;
    queue<pair<int, int>> J;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (board[i][j] == 'J') { // 지훈이 위치 dist 0으로 초기화
                dist_J[i][j] = 0; 
                J.push({ i,j });
            }
            if (board[i][j] == 'F') { // 불 위치 큐에 push
                dist[i][j] = 0;
                Q.push({ i,j });
            }
        }
    }

    // 불에 대해 bfs를 돌려서 각 위치까지 불이 번지기 위해 걸리는 시간 dist에 구함
    while (!Q.empty()) {
        auto cur = Q.front(); Q.pop();

        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // bound check
            if (board[nx][ny] != '.') continue; 
            if (dist[nx][ny] >= 0) continue; // 이미 방문했던 곳

            // 여기까지 오면 (nx, ny) 로 이동 가능
            dist[nx][ny] = dist[cur.X][cur.Y] + 1; // 거리 비용 +1
            Q.push({ nx,ny });
        }
    }


    // 지훈이에 대해 bfs를 돌려서 불보다 dist값이 적은 위치에 대해 구하면서 가장자리 도착 여부 판단
    while (!J.empty()) {
        auto cur = J.front(); J.pop();

        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // bound check
            if (board[nx][ny] != '.') continue; 
            if (dist_J[nx][ny] >= 0) continue; // 이미 방문했던 곳

            if (dist_J[cur.X][cur.Y] + 1 >= dist[nx][ny]) continue; //불보다 빨리 해당 위치에 도착할 수 있는지 판단


            dist_J[nx][ny] = dist_J[cur.X][cur.Y] + 1; // 거리 비용 +1
            J.push({ nx,ny });
        }
    }

    int result = INF; // -1이 아닌 dist 중 최솟값 저장

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (i == 0 || i == R - 1 || j == 0 || j == C - 1) { // 가장자리면
                if (dist_J[i][j] >= 0) {
                    result = min(result, dist_J[i][j]);
                }
            }
        }
    }

    if (result == INF) { // 갱신 없으므로 탈출 못함
        cout << "IMPOSSIBLE";
        return 0;
    }


    /*
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cout << dist[i][j] << " ";
        }
        cout << "\n";
    }

    cout << "==========\n";

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cout << dist_J[i][j] << " ";
        }
        cout << "\n";
    }

    */

    
    cout << result + 1;
  
   
    return 0;
}


