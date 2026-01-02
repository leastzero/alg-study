#include<stdio.h>

int N,Q;
int A[70][70];
int L[1000];
int visited[70][70];
int SIZE;

int row[4]={-1,1,0,0};
int col[4]={0,0,-1,1};


//1. 입력 받기
// N,Q 입력
// 격자 크기=SIZE^2;
//SIZE*SIZE 크기의 얼음판 A

//2. Q번 반복
//회전 후 얼음 녹이기

void rotate(){
    int temp[70];
    //나눈 격자 한 변 길이=len
    //2^N * 2^N만큼의 격자로 전체 배열을 나누고, 나눠진 각 격자를 90도 회전시키기
    for(int r=0;r<SIZE;r+=len){
        for(int c=0;c<SIZE;c+=len){
            //회전
            //a행과 len-1-a열을 바꾸기
           
         for(int a=0;a<len;i++){
             for(int i=0;i<len;i++){
                 temp[i]=A[r+a][c+i];
             }
         }
            for(int j=0;j<len;j++){
                A[r+a][c+j]=A[r+j][c+(len-1-a)];
            }
            for(int k=0;k<len;k++){
                A[r+k][c+(len-1-a)]=temp[k];
            }
            
        }
    }
}

void melt(){
    int tempMelt[70][70];
    
    for(int i=0;i<SIZE;i++){
        for(int j=0;j<SIZE;j++){
           tempMelt[i][j]=A[i][j];          
        }
    }
    
    for(int i=0;i<SIZE;i++){
        int count=0;
        for(int j=0;j<SIZE;j++){
           if(tempMelt[i][j]==0) continue;
            
           for(int k=0;k<4;k++){
               int a=k+row[k];
               int b=k+row[k];
               
               if(a<0 || b<0) continue;
               if(A[a][b]>0) count++;
           }
            if(count<3) temp[i][j]--;
        }
    }
}

//3. 모든 단계 종료 후 얼음의 총합 구하기
//4. 가장 큰 얼음 덩어리 구하기
//5. 결과 출력

int main()
{
    scanf("%d %d", &N, &Q);
    SIZE=N;
    
    //얼음판 배열 입력
    for(int i=0;i<SIZE;i++){
        for(int j=0;j<SIZE;j++){
            scanf("%d",A[i][j]);
        }
    }
    
    //파이어스톰 단계 입력
    for(int k=0;k<Q;k++){
        scanf("%d", &L[k]);
    }
    
}












