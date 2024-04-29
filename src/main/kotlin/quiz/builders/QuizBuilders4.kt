package quiz.builders

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        launch {
            fetchTwoFiles4()
            println("both files downloaded")
        }
    }
}

suspend fun fetchTwoFiles4() {
    coroutineScope { launch { fetchFile41() } }
    coroutineScope { launch { fetchFile42() } }
}

suspend fun fetchFile41() {
    println("starting download file1")
    delay(3_000)
    println("file1 download finished")
}

suspend fun fetchFile42() {
    println("starting download file2")
    delay(3_000)
    println("file2 download finished")
}