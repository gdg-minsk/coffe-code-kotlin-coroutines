package quiz.cancellation

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class MyPropagatingException : CancellationException()

/**
 * What will be printed?
 * **/
suspend fun main(): Unit = coroutineScope {
    launch {
        launch {
            delay(200)
            println("A")
        }
        delay(100)
        throw MyPropagatingException()
    }
    launch {
        delay(200)
        println("B")
    }
}