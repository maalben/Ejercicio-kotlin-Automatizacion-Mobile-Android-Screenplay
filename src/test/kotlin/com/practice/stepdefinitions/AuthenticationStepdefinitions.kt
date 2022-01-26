package com.practice.stepdefinitions

import com.practice.exceptions.AssertionsTest
import com.practice.exceptions.AssertionsTest.Companion.ALERT_MESSAGE_NO_EXPECTED
import com.practice.exceptions.AssertionsTest.Companion.NO_FOUND_TITLE_EXPECTED
import com.practice.models.TestData
import com.practice.questions.The
import com.practice.questions.TheAlert
import com.practice.stepdefinitions.Hook.Companion.mario
import com.practice.tasks.Load
import com.practice.tasks.Login
import cucumber.api.PendingException
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import net.serenitybdd.screenplay.GivenWhenThen.seeThat
import org.hamcrest.Matchers

class AuthenticationStepdefinitions {

    @Given("^(?:I|he) load test data$")
    fun loadTestData(data: MutableList<Map<String, String>>) {
        mario.wasAbleTo(Load.testData(data.get(0)))
    }

    @When("I try to login myself using my data authentication")
    fun iTryToLoginMyselfUsingMyDataAuthentication() {
        mario.attemptsTo(Login.inDemoApplicationSauceLabs())
    }

    @Then("I should see the title screen expected")
    fun iShouldSeeTheTitleScreenExpected() {
        mario.should(seeThat(The.titleIs(), Matchers.`is`(true))
                .orComplainWith(AssertionsTest::class.java, NO_FOUND_TITLE_EXPECTED)
        )
    }

    @Then("I should see the alert with message expected")
    fun iShouldSeeTheAlertWithMessageExpected() {
        mario.should(seeThat(TheAlert.message(), Matchers.`is`(TestData.getData()?.get("expected").toString()))
                .orComplainWith(AssertionsTest::class.java, ALERT_MESSAGE_NO_EXPECTED))
    }

}