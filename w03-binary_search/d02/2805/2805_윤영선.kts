#!/usr/bin/env kotlin

fun main() {

    val (N, target) = readLine()!!.split(" ").map { it.toInt() }

    var max = 0
    val trees = readLine()!!.split(" ").map {
        val h = it.toInt()
        if(h > max) max = h
        h
    }

    var left = 0L
    var right = max.toLong()

    var maxHeight = 0L

    while(left <= right) {
        val height = (left + right).toLong() / 2

        var curr = 0L // 현재 height값으로 잘라낼 수 있는 나무 길이

        for(i in 0 until N) {
            if(trees[i] <= height) continue
            curr += trees[i] - height
        }
        // println("curr= $curr")

        if( curr.toInt() == target ) {
            maxHeight = maxOf(maxHeight, height)
            // 값이 같더라도, 최고의 높이를 구하기 위해서,
            // 높이를 더 높이는 방향으로 찾아보자
            left = height + 1
        } else if( curr < target ) {
            // curr의 값을 올리려면, height가 줄어야 한다.
            right = height - 1
        } else {
            // curr > target
            // curr의 값을 줄이려면, height를 높여야 한다.
            left = height + 1
        }
    }

    print(maxHeight)
}