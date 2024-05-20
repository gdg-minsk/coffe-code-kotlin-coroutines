package quiz.builders

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() {
    coroutineScope {
        launch {
            fetchTwoFiles4()
            println("B")
        }
        println("A")
    }

    println("Middle")

    runBlocking {
        launch {
            fetchTwoFiles4()
        }
    }

    println("End")
}

suspend fun fetchTwoFiles4() {
    coroutineScope { launch { fetchFile41() } }
    coroutineScope { launch { fetchFile42() } }
}

suspend fun fetchFile41() {
    println("C")
    delay(3_000)
    println("D")
}

suspend fun fetchFile42() {
    println("E")
    delay(3_000)
    println("F")
}