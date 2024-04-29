package quiz.builders

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        launch {
            fetchTwoFiles3()
            println("0")
        }
    }
}

suspend fun fetchTwoFiles3() {
    coroutineScope {
        launch { fetchFile31() }
        launch { fetchFile32() }
    }
}

suspend fun fetchFile31() {
    println("1-1")
    delay(3_000)
    println("1-2")
}

suspend fun fetchFile32() {
    println("2-1")
    delay(3_000)
    println("2-2")
}