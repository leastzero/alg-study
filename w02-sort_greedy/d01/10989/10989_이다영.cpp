#include<stdio.h>

int N; //수의 개수
int arr[100];

int main(){
scanf("%d\n",&N);

for(int i=0;i<N-1;i++){
 scanf("%d\n",&arr[i]);
}

for(int i=0;i<N;i++){
for(int j=i+1;j<N;j++){
    if(arr[i]>arr[j]){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
}

for(int i=0;i<N;i++){
    printf("%d\n",arr[i]+1);
}

return 0;
}