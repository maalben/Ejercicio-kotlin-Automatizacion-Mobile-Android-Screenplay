package com.practice.tasks

import com.practice.models.TestData
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks.instrumented
import java.util.stream.Collectors

open class Load(private var data: Map<String, String>) : Task{

    override fun <T : Actor?> performAs(actor: T) {
        val testDataAux: Set<Map.Entry<String, String>> =
            data.entries
        TestData.setData(
            testDataAux.stream().collect(
                Collectors.toMap(
                    { it.key },{ it.value }
                )
            )
        )
    }

    companion object {
        fun testData(data: Map<String, String>): Load {
            return instrumented(Load::class.java, data)
        }
    }
}