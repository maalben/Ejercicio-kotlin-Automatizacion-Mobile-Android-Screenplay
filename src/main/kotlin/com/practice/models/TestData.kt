package com.practice.models

import java.util.*

object TestData {

    private var map: Map<String, String> = HashMap()

    fun getData(): Map<String, String>? {
        return map
    }

    fun setData(testData: Map<String, String>) {
        map = testData
    }

}