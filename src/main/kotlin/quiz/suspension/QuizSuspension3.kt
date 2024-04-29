//package quiz.suspension
//
//import kotlin.coroutines.Continuation
//import kotlin.coroutines.CoroutineContext
//
///**
// * The function starts at the beginning with a field called a label set
// * to 0 and prints Before. Write the missing code so we can set the
// * label to the next state before each suspension point.
// * Also, specify a delay of one second and print After between
// * the suspension and resumption.
// *
// * Output:
// * Before
// * After
// */
//suspend fun myFunction() {
//    println("Before")
//    delay(1000)
//    println("After")
//}
//
//fun myFunction(continuation: Continuation<Unit>): Any {
//    val continuation = continuation as? MyFunctionContinuation ?: MyFunctionContinuation(continuation)
//    if (continuation.label == 0) {
//        println("Before")
//        continuation.label = 1
//        if (delay(1000, continuation) == COROUTINE_SUSPENDED) {
//            return COROUTINE_SUSPENDED
//        }
//        //complete the code
//    }
//    if (continuation.label == 1) {
//        println("After")
//    }
//    // complete the code here as well
//    error("Impossible")
//}
//
//class MyFunctionContinuation(
//    val completion: Continuation<Unit>,
//) : Continuation<String> {
//
//    var label = 0
//
//    override val context: CoroutineContext
//        get() = TODO("Not yet implemented")
//
//    override fun resumeWith(result: Result<String>) {
//        TODO("Not yet implemented")
//    }
//}