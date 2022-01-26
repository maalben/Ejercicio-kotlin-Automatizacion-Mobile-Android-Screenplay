package com.practice.questions

import com.practice.models.TestData
import com.practice.userinterfaces.AuthenticationUserInterfaces.Companion.LABEL_PRODUCTS
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible
import net.serenitybdd.screenplay.questions.Text
import net.serenitybdd.screenplay.waits.WaitUntil
import org.assertj.core.api.SoftAssertions

class The: Question<Boolean> {

    private val validateSendValues = SoftAssertions()

    override fun answeredBy(actor: Actor?): Boolean {
        var flag = false

        actor!!.attemptsTo(WaitUntil
                .the(LABEL_PRODUCTS, isVisible())
                .forNoMoreThan(20)
                .seconds())
        if (LABEL_PRODUCTS.resolveFor(actor).isVisible) {
            flag = true
            validateSendValues.assertThat(Text.of(LABEL_PRODUCTS).viewedBy(actor).asString())
                    .isEqualTo(TestData.getData()?.get("expected")
                            .toString())
            validateSendValues.assertAll()
        }
        return flag
    }

    companion object {
        fun titleIs(): The {
            return The()
        }
    }
}