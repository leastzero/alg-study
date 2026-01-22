#!/usr/bin/env kotlin

import java.util.*

fun main() {
    val N = readLine()!!.toInt()

    val st = StringTokenizer(readLine()!!, " ")

    val arr = IntArray(N) {
        st.nextToken().toInt()
    }

    // print(dp.contentToString())

    val dp = IntArray(N)
    // dp[i] - arr[i]번째에서 시작한 부분 수열의 길이

    // dp에서 최대값이 위치한 인덱스를 찾아서
    // 그 인덱스부터 길이만큼 부분 수열을 출력하면 될듯


    // dp 배열 완성.. N^2 해도 괜찮나?
    // dp[0] - arr[0] 부터 시작한 부분 수열의 길이
    var maxCount = 1
    var maxIdx = 0

    for(i in 0 until N) {
        var before = arr[i]
        var count = 1
        // print("$before ")

        for(j in i until N) {
            if(arr[j] > before) {
                before = arr[j]
                // print("$before ")
                count++
            }
        }

        println()
        if(count > maxCount) {
            maxCount = count
            maxIdx = i
        }

        dp[i] = count
    }

    println(maxCount)

    var before = arr[maxIdx]
    // println("maxIdx = $maxIdx")
    print("$before ")
    maxCount--

    for(i in maxIdx until N) {
        if(maxCount == 0) break

        if(arr[i] > before) {
            before = arr[i]
            print("$before ")
            maxCount--
        }
    }
}