package quiz.builders

import demo.suspension.delay
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

suspend fun main() {
    coroutineScope {
        val first = async {
            println("C")
            delay(100)
            println("D")

            "First Async"
        }

        val second = async {
            println("E")
            delay(400)
            println("F")

            "Second Async"
        }

        runBlocking {
            println("G")
            delay(300)

            println("H")
            println("${first.await()} ${second.await()}")
        }

        println("B")
    }
    println("A")
}
