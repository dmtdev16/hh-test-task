package com.example.myapplication

class ArraySearcher {
    fun getArrayMaxIndex(array: Array<String>) : Int {
        var maxValue = array[0]
        var maxIndex = 0
        for (i in array.indices){
            if (array[i] > maxValue){
                maxValue = array[i]
                maxIndex = i
            }
        }
        return maxIndex
    }
}