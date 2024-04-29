//package demo.suspension
//
//import kotlin.coroutines.Continuation
//
//suspend fun myFunction() {
//    println("Before")
//    delay(1000) // suspending
//    println("After")
//}
//
//// ==========================================
//fun myFunction(continuation: Continuation<Unit>): Any {
//    /**
//     * Next, this function needs its continuation to remember its state.
//     * We should do this only if we haven't wrapped the continuation already.
//     */
//    val continuation = continuation as? MyFunctionContinuation
//        ?: MyFunctionContinuation(continuation)
//
//    if (continuation.label == 0) {
//        println("Before")
//        continuation.label = 1
//
//        /**
//         * COROUTINE_SUSPENDED is propagated until it reaches either
//         * the builder function or the resume function.
//         * This is how a suspension ends all these functions and leaves the
//         * thread available for other runnable (including coroutines) to be used.
//         */
//        if (delay(1000, continuation) == COROUTINE_SUSPENDED) {
//            return COROUTINE_SUSPENDED
//        }
//    }
//    if (continuation.label == 1) {
//        println("After")
//        return Unit
//    }
//    error("Impossible")
//}