package quiz.exception

import demo.suspension.MyException
import demo.suspension.delay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

suspend fun main() {
    val scope = CoroutineScope(Job())

    scope.launch {
        launch {
            throw MyException()
        }
        delay(500L)

        println("A")
    }

    delay(100L)

    scope.launch {
        delay(700L)
        println("B")
    }

    delay(1000L)
    println("C")
}