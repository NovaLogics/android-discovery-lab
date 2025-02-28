@file:OptIn(DelicateCoroutinesApi::class)

package novalogics.android.discoverylab

import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TAG: String = "TestCoroutines"

fun testCoroutines() {

// 01 - First Coroutine
  //  testFirstCoroutine()

// 02 - Suspend Functions
    testSuspendFunctions()

}

fun testFirstCoroutine() {
    GlobalScope.launch {
        delay(2000L)
        Log.d(TAG, "Hello from COROUTINE | Thread : ${Thread.currentThread().name}")
    }
    Log.d(TAG, "Hello from thread | Thread : ${Thread.currentThread().name}")
}

fun testSuspendFunctions() {
    GlobalScope.launch {
        Log.d(TAG, "COROUTINE | Thread : ${Thread.currentThread().name}")

        val networkCallOne = doNetworkCall()
        val networkCallTwo = doAnotherNetworkCall()

        Log.d(TAG, networkCallOne)
        Log.d(TAG, networkCallTwo)
    }
}

suspend fun doNetworkCall(): String {
    delay(2000L)
    return "1st Network Call"
}

suspend fun doAnotherNetworkCall(): String {
    delay(2000L)
    return "2nd Network Call"
}
