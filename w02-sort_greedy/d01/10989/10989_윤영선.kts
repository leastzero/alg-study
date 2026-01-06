#!/usr/bin/env kotlin

import java.io.*
fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = readLine()!!.toInt()
    val arr = IntArray(n) {
        readLine()!!.toInt()
    }

    // 버블 정렬
    fun bubbleSort() {
        for(i in 0 until n) {
            for(j in 0 until n-1-i) {
                if(arr[j] > arr[j+1]) {
                    val tmp = arr[j]
                    arr[j] = arr[j+1]
                    arr[j+1] = tmp
                }
            }
        }
    }

    arr.forEach {
        bw.write("$it\n")
    }

    bw.flush()
    bw.close()
}