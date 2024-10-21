package demo.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

suspend fun main(): Unit = coroutineScope {
    println(Runtime.getRuntime().availableProcessors())

    launch {
        printCoroutinesTime1(Dispatchers.Default)
    }
}

private suspend fun printCoroutinesTime1(
    dispatcher: CoroutineDispatcher
) {

    val test = measureTimeMillis {
        coroutineScope {
            repeat(10) {
                launch(dispatcher) {
                    Thread.sleep(1000)
                }
            }
        }
    }
    println("#1 $dispatcher took: $test")
}