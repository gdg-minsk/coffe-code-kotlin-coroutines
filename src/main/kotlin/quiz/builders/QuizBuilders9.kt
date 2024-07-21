package quiz.builders

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        launch {
            delay(200L)
            println("1")
        }
        coroutineScope {
            launch {
                delay(500L)
                println("2")
            }
            val job = async {
                delay(2000L)
                println("3")
            }
            delay(100L)
            println("4")

            job.await()
        }
        println("5")
    }
    println("6")
}
