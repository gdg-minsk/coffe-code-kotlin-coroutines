package quiz.flow

import demo.flow.MyError
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

val flow3 = flow {
    emit("Message1")
    emit("Message2")
}

suspend fun main(): Unit {
    flow3.onStart { println("Before") }
        .catch { println("Caught $it") }
        .collect { throw MyError() }
}
