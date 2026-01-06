#!/usr/bin/env kotlin

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()

    //단, 회의는 한번 시작하면 중간에 중단될 수 없으며
    //한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.

    var maxTime = 0
    val list = mutableListOf<Pair<Int,Int>>()

    repeat(N) {
        val (s, e) = readLine()!!.split(" ").map { it.toInt() }

        list.add(Pair(s, e))

        // 시작시간 s와 끝나는 시간 e는 같을 수 있다.
        // 시간 범위 : 0 ~ 2^31-1
        maxTime = maxOf(maxTime, e)
    }

    // 시작시간 기준으로 오름차순 정렬...
    val sortedList = list.sortedBy { it.first }

    // println(sortedList)
    var used = BooleanArray(maxTime+1)
    var maxCount = 0

    // 하나 골라서 그게 맞다고 설정했을 때,
    for(i in 0 until N) {
        used = BooleanArray(maxTime+1)

        val start = sortedList[i].first
        val end = sortedList[i].second

        // println("start: $start, end:$end")
        var count = 1

        // 색칠하고
        for(j in start..end) {
            used[j] = true
        }

        // 다음 시간부터 계속 확인
        for(j in 0 until N) {
            if(i == j) continue

            var isAvailable = true

            val nxtStart = sortedList[j].first
            val nxtEnd = sortedList[j].second
            // println("nxtStart: $nxtStart, nxtEnd: $nxtEnd")

            for(k in nxtStart..nxtEnd) {
                if( used[k] ) {
                    isAvailable = false
                    break
                }
            }

            // 다음 시간이 사용 가능하다면, 색칠
            if(isAvailable) {
                count++

                for(k in nxtStart..nxtEnd) {
                    used[k] = true
                }
            }

            // println("isAvailable: $isAvailable")
        }


        maxCount = maxOf(maxCount, count)
    }

    println(maxCount)

}