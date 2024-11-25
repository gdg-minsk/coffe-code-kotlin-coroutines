package quiz.flow

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val mutableSharedFlow = MutableSharedFlow<String>(replay = 0)
    val job1 = launch {
        mutableSharedFlow.collect {
            println("#1 $it")
        }
    }
    val job2 = launch {
        mutableSharedFlow.collect {
            println("#2 $it")
        }
    }
    delay(1000)
    mutableSharedFlow.emit("A")
    mutableSharedFlow.emit("B")
}