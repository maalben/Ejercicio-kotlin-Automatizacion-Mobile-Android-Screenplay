package com.practice.runners

import io.cucumber.junit.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(
    features = ["src/test/resources/features/authentication.feature"],
    plugin = ["pretty"],
    glue = ["com.practice.stepdefinitions"],
    snippets = CucumberOptions.SnippetType.CAMELCASE
    )
class AuthenticationRunner {}