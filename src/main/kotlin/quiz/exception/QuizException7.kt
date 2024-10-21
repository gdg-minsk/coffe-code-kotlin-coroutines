package quiz.exception

import demo.suspension.MyException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    val scope = CoroutineScope(SupervisorJob())

    scope.launch {
        delay(200L)
        println("A")
    }

    scope.launch {
        delay(100L)
        throw MyException()
    }

    delay(400L)
    println("C")
}


