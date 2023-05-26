import kotlinx.coroutines.*;
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.util.*

   fun clock():Flow<Date> = flow {
    while (true) {
            delay(1000)
                emit(Date())
    }
}.onStart {
    println("Clock started")
}.onCompletion {
       println("Clock completed")
}

fun main() = runBlocking {
    val clockFlow = clock()
    clockFlow.collect {
        delay(1000)
            println("Current time is : $it")
        }

    }
