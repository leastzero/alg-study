//흐름: 테스트 케이스별
//n일의 주가를 확인한다.
//미래를 알기에 다음날 비싸지면 사놓다가
//이득을 볼 수 있을 때 판다.
//다음날 주가가 떨어지면 안사도 된다.
//자료형을 배열에다가 집어넣으면 안된다.

//주식을 몇개샀는지를 나타내는 변수, 현재가를 나타내는 변수, 팔았을때 합산하는 변수
#include<bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(fase);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;

    int n;
    for(int i=0; i<t; i++){
        cin >> n;
        //주식사모은 횟수 : stock
        int stock=0
        //샀을때 합산하는 변수
        int price=0
        //팔았을때 합산하는 변수
        int sum =0;
        int arr[n];
        for(int j=0; j<n;j++){
            cin >> arr[j];
        }
        for(int j=0; j<n;j++){
            for(int k=j;k<n;k++){
                //앞이 뒤보다 크면 stock * arr[뒤에]
                if(arr[j] > arr[k]){
                    sum += stock*arr[k];
                    stock = 0;
                    continue;
                }else{
                    
                }
            }
        }
        
    }

    

    return 0;
}
