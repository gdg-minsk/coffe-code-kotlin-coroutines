package quiz.flow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach

val flow = flow {
    emit(1)
    emit(2)
    throw Exception()
}

suspend fun main(): Unit {
    flow.onEach { println("A $it") }
        .catch { emit(0) }
        .collect { println("B $it") }
}