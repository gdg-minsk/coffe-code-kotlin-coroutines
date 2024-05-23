package demo.job

import demo.suspension.delay
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * This is used to complete a job. Once we have used it, all the child coroutines will
 * keep running until they are all done, but we cannot start new coroutines in this job.
 */
fun main() = runBlocking {
    val job = Job()

    launch(job) {
        repeat(5) { num ->
            delay(200)
            println("Rep$num")
        }
    }

    launch {
        delay(500)
        job.complete()
    }

    job.join()

    launch(job) {
        println("Will not be printed")
    }

    println(job)

    println("Done")
}