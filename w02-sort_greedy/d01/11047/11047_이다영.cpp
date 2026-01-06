#include<stdio.h>

int N; //동전의 종류
int K; //총 합
int arr[11];

int main(){
    scanf("%d %d\n",&N,&K);

    for(int i=0;i<N-1;i++){
        scanf("%d\n",&arr[i]);
    }

    int count=0;
    int change;

    for(int i=N-1;i>=1;i--){
         count+= K/arr[i];
         change= K%arr[i];

         if(count>0){
            K=change;
         } 
    }

    printf("%d\n",count);
}