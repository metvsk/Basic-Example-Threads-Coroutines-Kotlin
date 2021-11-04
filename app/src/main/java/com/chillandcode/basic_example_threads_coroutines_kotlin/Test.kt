package com.chillandcode.basic_example_threads_coroutines_kotlin

import android.annotation.SuppressLint
import android.os.Build
import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
////single thread - test1
//test1()

////multiple threads example - test2
// test2()

    ////Coroutines basic test
//test3()
    ////    https://developer.android.com/codelabs/basic-android-kotlin-training-introduction-coroutines?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-4-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-introduction-coroutines#3

    ////run blocking test
    test4()


}

private fun test1() {
    val thread = Thread {
        println("${Thread.currentThread()} has run")
    }
    thread.start()
}

private fun test2() {
    val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
    repeat(3) {
        Thread {
            println("${Thread.currentThread()} has started...")
            for (i in states) {
                println("${Thread.currentThread()}-$i")
                Thread.sleep(100)
            }
        }.start()
    }
}

private fun test3() {

//RUN THIS ON KOTLIN PLAY GROUND
    //https://play.kotlinlang.org/
//    import kotlinx.coroutines.*
    repeat(3) {
        GlobalScope.launch {
            println("Hi from ${Thread.currentThread()}")
        }
    }



}
//RUN BLOCKING TEST
@SuppressLint("NewApi")
fun test4(){


    val formatter = DateTimeFormatter.ISO_LOCAL_TIME
    val time = { formatter.format(LocalDateTime.now()) }

    suspend fun getValue(): Double {
        println("entering getValue() at ${time()}")
        delay(3000)
        println("leaving getValue() at ${time()}")
        return Math.random()
    }

    fun main() {
        runBlocking {
            val num1 = getValue()
            val num2 = getValue()
            println("result of num1 + num2 is ${num1 + num2} at ${time()}")
        }
    }
}