package quiz.flow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach

val flow1 = flow {
    emit(1)
    emit(2)
}

suspend fun main(): Unit {
    flow1.onEach { println("A $it") }
        .catch { emit(0) }
        .onEach { throw MyError() }
        .collect { println("B $it") }
}