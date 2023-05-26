import kotlinx.coroutines.*;
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.util.*

fun main(){
    runBlocking {
        launch {
            checkName().filter {
                it.length>3
            }.map {
                var mystring = ""
                for(i in it.indices){
                    if(it[i].isLetter()){
                        mystring+=it[i]
                    }
                }
                it.replace(it, mystring)
            }.map {
                it.substring(it.length-3,it.length)

            }.collect{
                delay(500)
                println(it)
            }
        }
    }
}

private fun checkName():Flow<String>{
    return flow {
        var myName = ""
        while(true){
            println("ENTER THE VALUE FOR THE NAME :::")
            val input = readln()
            if(!input.equals(myName)){
                emit(input)
            }
        }
    }
}
