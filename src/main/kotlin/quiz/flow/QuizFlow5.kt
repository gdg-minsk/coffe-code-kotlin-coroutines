package quiz.flow

import demo.flow.MyError
import kotlinx.coroutines.flow.*

val flow5 = flow {
    emit("Test")
    throw MyError()
}

suspend fun main(): Unit {
    flow5.onStart { println("A") }
        .catch { println("B $it") }
        .onEmpty { println("C") }
        .onCompletion { println("D") }
        .collect()
}
