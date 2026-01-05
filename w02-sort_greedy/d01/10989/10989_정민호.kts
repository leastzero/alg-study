// N개의 수가 주어졌을 때 오름차순으로 정렬해야 한다.
// 이 때 N이 10^7이어서, 단순 입력으로 받으면 시간 초과가 날 확률이 있다.
// 따라서 빠른 입력으로 받은 후 정렬하여 빠른 출력으로 처리해보도록 하자.

import java.io.*

fun main() {
    // br 객체: 빠른 입력 라이브러리
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    // N: 입력 받을 수
    // 왜 자꾸 컴파일 에러가 뜰까????????????
    bw.write(br.readLine().toInt())

    // arr: N개의 정수를 저장
    // val arr: Array<Int> = Array(N) { i -> i }

    // arr.forEach { print("$it") }

    bw.flush()
    bw.close()
}