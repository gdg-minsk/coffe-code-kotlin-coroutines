package quiz.suspension

import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Before")

    suspendCoroutine<Unit> { }

    println("After")
}