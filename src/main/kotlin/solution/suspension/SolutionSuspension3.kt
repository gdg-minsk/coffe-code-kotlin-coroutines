//package solution.suspension
//
//import demo.suspension.delay
//import quiz.suspension.MyFunctionContinuation
//import kotlin.coroutines.Continuation
//
//fun myFunction(continuation: Continuation<Unit>): Any {
//    val continuation = continuation as? MyFunctionContinuation ?: MyFunctionContinuation(continuation)
//    if (continuation.label == 0) {
//        println("Before")
//        continuation.label = 1
//        if (delay(1000, continuation) == COROUTINE_SUSPENDED) {
//            return COROUTINE_SUSPENDED
//        }
//
//    }
//    if (continuation.label == 1) {
//        println("After")
//        return Unit
//    }
//    error("Impossible")
//}
//
//private val COROUTINE_SUSPENDED = Any()