// 요약: 집은 수직 좌표 중에 n개가 있고 중복된 좌표를 갖지않는다.
//     한집에는 공유기 하나만 설치 가능
//     가장 인접한 두  공유기 사이의 거리를 가능한 크게
//     공유기는 집에다가 설치
//     c개의 공유기를 n개의 집에 적당히 설치해서 두 공유기 사이의 거리를 최대로

// 흐름: 1,2,4,8,9 여기서 c개의 공유기 갯수는 주어지는데
//     c와 다음 c의 거리가 최대가 되게
//     힌트가 말해주길 1,4,8 또는 1,4,9이면 가장인접한 공유기가 3이라는거 증명
//     아 가장 짧은 집간의 거리중에 제일 큰 숫자를 찾는거구나
//     이분 탐색을 통해 v[mid]와 v[v.size()-1]의 거리를 비교하고 (혹은 v[0]과의 거리를 비교)
//     while(c--)로 풀어보자

// ex) 2,3,4, 100000, 120000 와이파이가 3개일때 이 경우는 20000이네  
// ex) 1,2,6,8,10 => 1,6,10이거나 2,6,10으로 최대거리는 4
// ex) 1,6,24,44,60 => 23이 최대네 이걸 구하면서 nCc를 하게됐는데
// nCc를 먼저하고...
// 가장 인접한 거리의 최대값을 어떻게 구하지?



#include<bits/stdc++.h>
using namespace std;


int longLengthWifi(vector<int>& v, int wifi){
    if(wifi == 2)return (v[v.size()-1] - v[0]);
    int l=0;
    int r=v.size()-1;
    int lengthR,lengthL;
    long long mn = 9999999999;
    //와이파이의 갯수만큼 이분탐색을 하면 왼쪽길이와 오른쪽길이의 최솟값을 구해
    while(wifi--){
        int mid = (l+r)/2;
        lengthR = v[r]-v[mid];
        lengthL = v[mid]-v[l];
        if(lengthR < lengthL){
            l = mid + 1;
        }else{
            r = mid - 1;
        }
        mn = min(lengthR,lengthL);
    }
    
    return mn;
}
    
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n,c;
    vector<int> v(n);
    cin >> n >> c;
    for(int i=0; i<n;i++){
        cin >> v[i];
    }
    sort(v.begin(),v.end());

    cout << longLengthWifi(v,c) << "\n";
    return 0;
}
