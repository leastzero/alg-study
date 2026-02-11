#!/usr/bin/env kotlin

fun main() {
    val s = readLine()!!
    val zeroCount = s.count{ it == '0' } / 2
    val oneCount = s.count{ it == '1' } / 2

    val subStrList = mutableListOf<String>()

    for(i in 0 until s.length - (zeroCount + oneCount)) {
        // println("i = $i , ${i + zeroCount + oneCount}")
        // println(s.slice( i until (i + zeroCount + oneCount) ) )
        val subStr = s.slice(i until (i + zeroCount + oneCount) )
        if( subStr.count { it == '1'} == oneCount
            && subStr.count { it == '0' } == zeroCount
        ) {
            subStrList.add(subStr)
        }
    }

    print(subStrList.sorted()[0])
}