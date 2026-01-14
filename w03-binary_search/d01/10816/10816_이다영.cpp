#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
    int x = *(int *)a;
    int y = *(int *)b;
    return x - y;
}

int LowerTarget(int arr[], int n, int target)
{
    int left = 0, right = n;
    while (left < right)
    {
        int mid = (left + right) / 2;
        if (arr[mid] < target)
            left = mid + 1;
        else
            right = mid;
    }
    return left;
}

int UpperTarget(int arr[], int n, int target)
{
    int left = 0, right = n;
    while (left < right)
    {
        int mid = (left + right) / 2;
        if (arr[mid] <= target)
            left = mid + 1;
        else
            right = mid;
    }
    return left;
}

int main()
{
    int N;
    scanf("%d", &N);

    int cards[500000];
    for (int i = 0; i < N; i++)
        scanf("%d", &cards[i]);

    qsort(cards, N, sizeof(int), compare);

    int M;
    scanf("%d", &M);

    for (int i = 0; i < M; i++)
    {
        int x;
        scanf("%d", &x);
        int count = UpperTarget(cards, N, x) - LowerTarget(cards, N, x);
        printf("%d ", count);
    }
}
