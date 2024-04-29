package quiz.builders

import demo.suspension.delay
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

suspend fun main() {
    coroutineScope {
        val first = async {
            println("1")
            delay(100)
            "First Async"
        }


        val second = async {
            println("2")
            delay(400)
            "Second Async"
        }

        runBlocking {
            delay(300)
            println("3")
            println("${first.await()} ${second.await()}")
        }
    }
}
