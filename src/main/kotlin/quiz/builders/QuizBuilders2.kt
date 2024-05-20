package quiz.builders

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() {
    coroutineScope {
        launch {
            fetchTwoFiles()
            println("B")
        }
    }

    println("A")
}

suspend fun fetchTwoFiles() {
    fetchFile1()
    fetchFile2()
}

suspend fun fetchFile1() {
    println("C")
    delay(3_000)
    println("D")
}

suspend fun fetchFile2() {
    println("E")
    delay(3_000)
    println("F")
}