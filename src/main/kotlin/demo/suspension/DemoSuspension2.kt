package demo.suspension

import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Before")

    suspendCoroutine<Unit> {
        println("Before too")
    }

    println("After")
}