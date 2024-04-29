package demo.suspension

suspend fun myFunction1() {
    println("Before")
    delay(1000) // suspending
    println("After")
}