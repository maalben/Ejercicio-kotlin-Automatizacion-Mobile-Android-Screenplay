package com.practice.tasks

import com.practice.interactions.Verify
import com.practice.models.TestData
import com.practice.userinterfaces.AuthenticationUserInterfaces.Companion.BUTTON_LOGIN
import com.practice.userinterfaces.AuthenticationUserInterfaces.Companion.TEXTFIELD_PASSWORD
import com.practice.userinterfaces.AuthenticationUserInterfaces.Companion.TEXTFIELD_USER
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks
import net.serenitybdd.screenplay.actions.Click
import net.serenitybdd.screenplay.actions.Enter

open class Login : Task {

    override fun <T : Actor?> performAs(actor: T) {
        actor?.attemptsTo(Verify.beShowElement(TEXTFIELD_USER, "visible"))
        actor?.attemptsTo(Enter.theValue(TestData.getData()?.get("user").toString()).into(TEXTFIELD_USER))
        actor?.attemptsTo(Enter.theValue(TestData.getData()?.get("pass").toString()).into(TEXTFIELD_PASSWORD))
        actor?.attemptsTo(Click.on(BUTTON_LOGIN))
    }

    companion object {
        fun inDemoApplicationSauceLabs(): Login {
            return Tasks.instrumented(Login::class.java)
        }
    }
}