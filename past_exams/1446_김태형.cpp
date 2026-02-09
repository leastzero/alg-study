//원래 가중치는 점과 점의 거리만큼임
//하지만 지름길이 생기고 가중치가 그만큼 줄어들었음
//0에서 d까지의 거리를 가야되는데 
//지름길을 최대한 이용해서 목적지 d까지 최대한 짧게 가봐라~
#include<bits/stdc++.h>
using namespace std;

vector<pair<int,int>> adj[12];//그래프의 인접리스트 표현
vector<int> dist(12,10000);//최단거리 배열

int dijkstra(int start){
    //가장 맨 위에 작은 값이 있게 하려면 아래와 같이 우선순위큐를 선언해야함.
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
    dist[start] = 0;
    pq.push({0,start});
    int res = 0;
    while(!pq.empty()){
        int here_cost = pq.top().first;
        int u = pq.top().second;
        pq.pop();

        //느슨한 삭제?
        if(dist[u] != here_cost) continue;

        for(auto there : adj[u]){
            int new_cost = here_cost + there.second;
            if(new_cost<dist[there.first]){
                dist[there.first] = new_cost;
                pq.push({new_cost,there.first})
            }
        }
    }
    
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n,d;
    cin >> n >> d;
    int u,v,w
    for(int i=0; i<n;i++){
        cin >> u >> v >> w;
        adj[u].push_back({w,v});
    }
    
    dijkstra(0);    
    return 0;
}
