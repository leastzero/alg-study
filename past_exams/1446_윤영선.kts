#!/usr/bin/env kotlin

import java.util.*

fun main() {
    val (N, D) = readLine()!!.split(" ").map { it.toInt() }

    // N을 간선의 개수로 볼 수 있다.
    val graph = Array( D + 1 ) { mutableListOf<Pair<Int,Int>>() }
    val pq = PriorityQueue<Pair<Int, Int>>() { a, b -> a.second - b.second }
    val dist = IntArray( D + 1 ) { Int.MAX_VALUE }
    val visited = BooleanArray(D + 1)

    var minStart = Int.MAX_VALUE

    repeat(N) {
        val (start, end, cost) = readLine()!!.split(" ").map { it.toInt() }

        if( cost < end - start && end <= D) {
            graph[start].add(Pair(end, cost))
            minStart = minOf(minStart, start)
        }
    }

    // min 값에서 출발
    dist[minStart] = 0
    pq.add(Pair(minStart, 0))

    var curr = minStart  // 현재 위치
    var result = 0       // 이동한 위치

    while(pq.isNotEmpty()) {
        val nowNode = pq.poll()
        var now = nowNode.first

        // 현재 지점에서 갈 수 있는 지름길이 없다면
        if(graph[now].isEmpty()) {
            for(i in now+1..D) {
                curr += 1
                result += 1
                now += 1
                if(graph[i].isNotEmpty()) {
                    println(now)
                    println(result)
                    break
                }
            }
        }

        for( nextNode in graph[now] ) {
            val next = nextNode.first
            val cost = nextNode.second
            if(next < 0 || next > D) continue

            if( dist[next] > dist[now] + cost ) {
                dist[next] = dist[now] + cost
                pq.add( Pair(next, dist[next]) )

                curr = next
                result += cost
            }
        }
    }

    println("curr = $curr")
    println("result = $result")

    if(curr < D) {
        result += D - curr
    }

    println(result)
}