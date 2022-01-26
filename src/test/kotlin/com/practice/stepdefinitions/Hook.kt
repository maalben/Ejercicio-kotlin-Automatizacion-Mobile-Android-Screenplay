package com.practice.stepdefinitions

import io.cucumber.java.Before
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.thucydides.core.annotations.Managed
import org.openqa.selenium.WebDriver

class Hook{

    @Managed(driver = "appium")
    private val environment: WebDriver? = null
    companion object {
        @JvmStatic var mario: Actor = Actor.named("Mario")
    }

    @Before
    fun setup() {
        mario.can(BrowseTheWeb.with(environment))
    }

}