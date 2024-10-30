package demo.suspension

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * The executor uses a thread, but it's one thread for all coroutines using the delay function.
 * This is how delay from the Kotlin coroutines library used to be implemented.
 */

private val executor = Executors.newSingleThreadScheduledExecutor { runnable ->
    Thread(runnable, "scheduler")
        .apply { isDaemon = true }
}

suspend fun internalDelay(timeMillis: Long): Unit =
    suspendCoroutine { cont ->
        executor.schedule(
            /* command = */ { cont.resume(Unit) },
            /* delay = */ timeMillis,
            /* unit = */ TimeUnit.MILLISECONDS,
        )
    }

suspend fun main() {
    println("Before")

    internalDelay(1000)

    println("After")
}
