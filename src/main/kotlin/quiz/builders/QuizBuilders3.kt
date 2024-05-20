package quiz.builders

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        launch {
            fetchTwoFiles3()
            println("B")
        }
        println("A")
    }

    println("End")
}

suspend fun fetchTwoFiles3() {
    coroutineScope {
        launch { fetchFile31() }
        launch { fetchFile32() }
        println("C")
    }
}

suspend fun fetchFile31() {
    println("D")
    delay(3_000)
    println("E")
}

suspend fun fetchFile32() {
    println("F")
    delay(3_000)
    println("G")
}