package demo.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    flowOf(1, 2, 3, 4, 5)
        .collect { print(it) }
    // ==========================================
    emptyFlow<Int>()
        .collect { print(it) } // (nothing)

    println()

    // ==========================================
    listOf(1, 2, 3, 4, 5)
        // or setOf(1, 2, 3, 4, 5)
        // or sequenceOf(1, 2, 3, 4, 5)
        .asFlow()
        .collect { print(it) }

    println()

    // ==========================================
    val function = suspend {
        // this is suspending lambda expression
        delay(1000)
        "UserName"
    }

    function.asFlow()
        .collect { println(it) }
}
