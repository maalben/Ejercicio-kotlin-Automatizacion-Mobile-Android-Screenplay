package com.practice.questions

import com.practice.userinterfaces.AuthenticationUserInterfaces.Companion.ALERT_MESSAGE_ERROR
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible
import net.serenitybdd.screenplay.questions.Text
import net.serenitybdd.screenplay.waits.WaitUntil

class TheAlert: Question<String> {


    override fun answeredBy(actor: Actor?): String {
        actor!!.attemptsTo(WaitUntil
                .the(ALERT_MESSAGE_ERROR, isVisible())
                .forNoMoreThan(20)
                .seconds())
        return Text.of(ALERT_MESSAGE_ERROR).viewedBy(actor).asString()
    }

    companion object{
        fun message(): TheAlert  {
            return TheAlert()
        }
    }

}
