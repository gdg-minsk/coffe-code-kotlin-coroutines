package quiz.builders

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        launch {
            delay(200L)
            println("A")
        }
        coroutineScope {
            launch {
                delay(500L)
                println("B")
            }
            val job = async {
                delay(700L)
                println("C")
            }
            delay(100L)
            println("D")

            job.await()
        }
        println("E")
    }
    println("F")
}
