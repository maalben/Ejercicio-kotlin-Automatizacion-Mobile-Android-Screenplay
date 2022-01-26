package com.practice.interactions

import com.practice.exceptions.ErrorElementNoFound
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Interaction
import net.serenitybdd.screenplay.Tasks
import net.serenitybdd.screenplay.conditions.Check
import java.time.Duration.ofSeconds
import net.serenitybdd.screenplay.targets.Target

open class Verify(private val target: Target, private val action: String) : Interaction {

    override fun <T : Actor?> performAs(actor: T) {
        try {
            when(action){
                "visible" -> {
                    actor?.attemptsTo(Check.whether(target.waitingForNoMoreThan(ofSeconds(10)).resolveFor(actor).isVisible))
                }
                "present" -> {
                    actor?.attemptsTo(Check.whether(target.waitingForNoMoreThan(ofSeconds(10)).resolveFor(actor).isPresent))
                }
                "clickable" -> {
                    actor?.attemptsTo(Check.whether(target.waitingForNoMoreThan(ofSeconds(10)).resolveFor(actor).isClickable))
                }
            }

        } catch (e: Exception) {
            throw ErrorElementNoFound(
                    "\nElement not found in:   " + e.stackTrace[0].className + "/" + e.stackTrace[0].methodName + ":" + e.stackTrace[0].lineNumber
                            + "\nDetail error: \n" + e.toString().split("\n")[0])
        }
    }

    companion object {
        fun beShowElement(target: Target, action: String): Verify {
            return Tasks.instrumented(Verify::class.java, target, action)
        }
    }
}