#include<bits/stdc++.h>
using namespace std;
//우선순위큐를 사용
//우선순위큐란 top에 항상 내림차순으로 정렬되어있는 큐
//pq.top()할 경우 pq에 push받은 숫자중에 가장큰 숫자가 리턴
//pq에다가 가방이 허용가능한 무게 push
priority_queue<int> pq;
//information에다가 무게와 가격 순으로 push_back
vector<pair<int,int>> information;
int res;

//sort 함수의 3번째 파라미터에 함수를 넣을 수 있는데 아래의 함수가 그것.
//내가 정한 second는 가격 first는 무게
bool compare(pair<int,int> &a, pair<int,int> &b){
    //제일 먼저 가격을 내림차순하고 가격끼리 같을 때 무게도 내림차순
    if(a.second == b.second)
        return a.first > b.first;
    return a.second > b.second;
}
int main(){
    int n,k;
    cin >> n >> k;
    int m,v;
    for(int i=0; i<n;i++){
        cin >> m >> v;
        information.push_back({m,v});
    }
    //무게와 가격이 들어있는 vector 정렬
    //1.가격부터 내림차순
    //2.가격이 같을 경우 무게가 내림차순
    sort(information.begin(),information.end(),compare);

    //가방 사이즈
    int bagSize1;
    for(int i=0;i<k;i++){
        cin >> bagSize1;
        pq.push(bagSize1);
    }

    int index = 0;
    //가방 갯수 떨어질때까지 while
    while(!pq.empty()){
        //제일튼튼한 가방 꺼내기
        int bagSize2 = pq.top();
        pq.pop();
        while(index<n){
            //보물 무게가 가방을 이기면 continue
            if(information[index].first > bagSize2){
                index++;
                continue;
            //보물 무게보다 가방이 튼튼하면 가방에다가 담고 
            //가격 합하기
            }else{
                res += information[index].second;
                index++;
                break;
            }
        }
        
    }

    cout << res;
    return 0;
}
