package demo.flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    flowOf(1, 2, 3, 4)
        .onEach(::println)
        .collect()

    // ================================================
    flowOf(1, 2)
        .onEach { delay(1000) }
        .onStart { println("Before") }
        .collect(::println)

    // ================================================
    flowOf(1, 2)
        .onEach { delay(1000) }
        .onStart { emit(5) }
        .onStart { emit(6) }
        .onStart { emit(7) }
        .collect(::println)

    // ================================================
    flowOf(1, 2)
        .onEach { delay(100) }
        .onCompletion { println("Completed") }
        .collect(::println)

    println()

    val job = launch {
        flowOf(1, 2)
            .onEach { delay(1000) }
            .onCompletion { println("Completed") }
            .onCompletion { println("Completed!!!") }
            .onCompletion { println("Completed!!!!") }
            .collect(::println)
    }
    delay(1100)
    job.cancel()

    // ================================================
    flow<List<Int>> { delay(1000) }
        .onEmpty { emit(emptyList()) }
        .collect(::println)
}