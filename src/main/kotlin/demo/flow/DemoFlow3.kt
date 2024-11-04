package demo.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

fun makeFlow(): Flow<Int> = flow {
    repeat(3) { num ->
        delay(1000)
        emit(num)
    }
}

suspend fun main() {
    makeFlow()
        .collect { println(it) }
}