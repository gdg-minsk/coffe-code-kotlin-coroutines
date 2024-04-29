package demo.suspension

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Before")

    val result = suspendCoroutine<Unit> { continuation ->
        println("2")
        continuation.resume(Unit)
    }

    println("After")
}