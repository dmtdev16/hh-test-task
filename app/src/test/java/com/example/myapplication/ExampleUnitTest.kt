package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun getMaxElement_isCorrect() {
        assertEquals(2, Utils.getArrayMaxIndex(arrayOf("1", "2", "3")))
    }
}
