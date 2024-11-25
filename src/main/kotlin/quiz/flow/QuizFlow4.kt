package quiz.flow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

val flow3 = flow {
    emit("A")
    emit("B")
}

suspend fun main(): Unit {
    flow3.onStart { println("Before") }
        .catch { println("Caught $it") }
        .collect { throw Exception() }
}
