package demo.job

import demo.suspension.delay
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * In the example, the parent does not wait for their children
 * because it has no relation to them.
 * This is because the child uses the job from the argument as a parent,
 * so it has no relation to the runBlocking.
 *
 */
fun main(): Unit = runBlocking {
    launch(Job()) { // the new job replaces one from parent
        delay(1000)
        println("Will not be printed")
    }
}