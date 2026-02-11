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

string s;

int main() {
    FIO;

    cin >> s;

    int zero = 0;
    int one = 0;

    for (char c : s) {
        if (c == '0') {
            zero++;
        }
        else {
            one++;
        }
    }

    zero /= 2; // 사용할 0의 개수
    one /= 2; // 사용할 1의 개수

    string n_s; // 출력에 사용할 배열


    for (char c : s) {
        if (c == '1' && one >0) { // 먼저 앞에서 one개의 1은 스킵
            one--;
            continue;
        }
        else if (c == '1' && one == 0) {
            n_s += "1";
        }
        else if (c == '0') {
            n_s += "0";
        }
    }

    for (char c : n_s) {
        if (c == '0' && zero > 0) { // 앞에서 zero개의 0은 출력
            cout << c;
            zero--;
        }
        else if (c == '0' && zero == 0) {
            continue;
        }
        else {
            cout << c;
        }
    }
    

    // 11110000
    // 1100
   




    return 0;
}


