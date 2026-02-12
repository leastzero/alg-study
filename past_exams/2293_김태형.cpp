#include<bits/stdc++.h>
using namespace std;
//1 1 1 1 1 1 1 1 1 1 
//1 1 1 1 1 1 1 1 2
//1 1 1 1 1 1 2 2
//1 1 1 1 2 2 2
//1 1 2 2 2 2
//2 2 2 2 2
//1 1 1 1 1 5
//1 1 1 2 5
//1 2 2 5
//5 5

//5는 2,1,0
//2:5,4,3,2,1,0
//1:10,8,6,5,4,3,2,1,0

//k = a[0] + a[1] + a[2]

//가치 배열을 정렬을 해주고
//가치가 큰 순서부터 k를 나눠본다
//몫이 나올텐데 0,1,...몫까지 a[0]을 사용해서 k를 만들 수 있는 경우의 수가 나온다.
//이렇게 하면 N중 for문이 나온다..?

//내림차순을 위한 함수
bool compare(int i,int j){
    return j < i;
}

int N,K;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> N >> K; 
    int a[N];
    int dp[N];
    for(int i=0; i<N;i++){
        cin >> a[i];
    }
    sort(a,a+N,compare);
    for(int i=0; i<N;i++){
        //2,5,10이 저장
        dp[i] = K / a[i];
    }
    //동전갯수만큼 반복해라
    for(int i=0; i<N;i++){
        //가치가 큰 동전부터 사용해서 k의 가치로 만들어가라
        for(int j=0; j<dp[i]; j++){
            
        }
    }

    
    return 0;
}
