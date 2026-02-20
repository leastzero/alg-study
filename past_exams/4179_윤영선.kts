#!/usr/bin/env kotlin

import java.util.*

fun main() {
    val (R, C) = readLine()!!.split(" ").map { it.toInt() }

    var start :Pair<Int, Int> /// 지훈이 시작 위치

    val map = Array(R) { Array(C) {""} }
    val countMap = Array(R) { IntArray(C) { -1 } }
    val fireMap = Array(R) { IntArray(C) { -1 } }

    for(r in 0 until R) {
        val st = StringTokenizer(readLine()!!, "")
        for(c in 0 until C) {
            val ch = st.nextToken()
            map[r][c] = ch

            if(ch == "#") {
                countMap[r][c] = -1
                fireMap[r][c] = -1
            }

            if(ch == "J") {
                countMap[r][c] = 0
                start = r to c
            }
        }
    }

    // BFS를 통해 각자 칸에 불이 도착할 수 있는 시간을 기입해보자.

    val dx = arrayOf(-1,0,1,0)
    val dy = arrayOf(0,-1,0,1)

    fun initFire(startFire: Pair<Int, Int>) {
        val visited = Array(R) { BooleanArray(C) }

        val queue = LinkedList<Pair<Int,Int>>()
        queue.add(startFire)

        visited[startFire.first][startFire.second] = true
        fireMap[startFire.first][startFire.second] = 0  // 불의 출발 지점

        while(queue.isNotEmpty()) {
            val (sx, sy) = queue.poll()

            for(i in 0 until 4) {
                val nx = sx + dx[i]
                val ny = sy + dy[i]

                // 이동할 수 있는지 확인
                if(fireMap[nx][ny] == -1) continue
                if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue
                if(visited[nx][ny]) continue

                map[nx][ny] = map[sx][sy] + 1
                queue.add(nx to ny)
            }
        }
    }

    // 1. 불이 이동할 수 있는 지도를 먼저 그리자.
    for( i in 0 until R ) {
        for(j in 0 until C) {
            if(map[i][j] == "F") initFire(i to j)
        }
    }

    for(i in 0 until R) {
        for(j in 0 until C) {
            print("${fireMap[i][j]} ")
        }
        println()
    }
}
