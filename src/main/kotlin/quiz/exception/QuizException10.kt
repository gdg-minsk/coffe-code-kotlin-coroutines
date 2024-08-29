package quiz.exception

import demo.suspension.MyException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

suspend fun main() {
    val scope = CoroutineScope(SupervisorJob())

    val job = scope.async {
        throw MyException()
    }

    try {
        job.await()
    } catch (e: Throwable) {
        println("A")
    }

    delay(1000L)
    println("B")
}


