package demo.dispatchers

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

val mutex = Mutex()

var counterV3 = 0

fun main() = runBlocking {
    massiveRunV3 {
        mutex.withLock {
            counterV3++
        }
    }
    println(counterV3)
}

suspend fun massiveRunV3(action: suspend () -> Unit) =
    withContext(Dispatchers.Default) {
        repeat(1000) {
            launch {
                repeat(1000) { action() }
            }
        }
    }