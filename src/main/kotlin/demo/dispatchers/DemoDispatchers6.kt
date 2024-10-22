package demo.dispatchers

import kotlinx.coroutines.*

val dispatcher = Dispatchers.IO
    .limitedParallelism(1)

var counterV2 = 0

fun main() = runBlocking {
    massiveRunV2 {
        withContext(dispatcher) {
            counterV2++
        }
    }
    println(counterV2) // 1000000
}

suspend fun massiveRunV2(action: suspend () -> Unit) =
    withContext(Dispatchers.Default) {
        repeat(1000) {
            launch {
                repeat(1000) { action() }
            }
        }
    }