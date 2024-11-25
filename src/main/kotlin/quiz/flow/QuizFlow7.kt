package quiz.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

val flow7 = flow {
    withContext(Dispatchers.IO) {
        emit(42)
    }
}

suspend fun main(): Unit {
    flow7
        .onEach { println("Hello $it") }
        .collect()
}