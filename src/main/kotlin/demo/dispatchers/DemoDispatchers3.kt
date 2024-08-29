package demo.dispatchers

import kotlinx.coroutines.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
suspend fun main(): Unit =
    withContext(newSingleThreadContext("Thread1")) {
        var continuation: Continuation<Unit>? = null

        launch(newSingleThreadContext("Thread2")) {
            delay(1000)
            continuation?.resume(Unit)
        }

        launch(Dispatchers.Unconfined) {
            println(Thread.currentThread().name) // Thread1

            suspendCancellableCoroutine<Unit> {
                continuation = it
            }

            println(Thread.currentThread().name) // Thread2

            delay(1000)

            println(Thread.currentThread().name)
        }
    }