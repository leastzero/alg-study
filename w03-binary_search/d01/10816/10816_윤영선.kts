#!/usr/bin/env kotlin

fun main() {
    val N = readLine()!!.toInt()
    val cards = readLine()!!.split(" ").map { it.toInt() }
    val sorted = cards.sorted()

    val m = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map { it.toInt() }

    println(sorted)
    val sb = StringBuilder()
    for( num in nums ) {
        var count = 0

        var left = 0
        var right = N - 1

        while(left <= right) {
            val mid = (left + right) / 2

            if(sorted[mid] == num) {
                count++
                right = mid - 1
            } else if(sorted[mid] > num) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        sb.append(count).append(" ")
    }

    println(sb)
}