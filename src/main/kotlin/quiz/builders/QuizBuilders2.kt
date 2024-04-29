package quiz.builders

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        launch {
            fetchTwoFiles()
            println("0")
        }
    }
}

suspend fun fetchTwoFiles() {
    fetchFile1()
    fetchFile2()
}

suspend fun fetchFile1() {
    println("1-1")
    delay(3_000)
    println("1-2")
}

suspend fun fetchFile2() {
    println("2-1")
    delay(3_000)
    println("2-2")
}