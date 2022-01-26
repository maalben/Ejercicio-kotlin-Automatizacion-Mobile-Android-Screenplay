package com.practice.exceptions

class AssertionsTest : AssertionError {

    companion object {

        const val NO_FOUND_TITLE_EXPECTED = "The title is not expected"
        const val ALERT_MESSAGE_NO_EXPECTED = "The alert message is not expected"

    }

    public constructor(message: String, cause: Throwable):super(message, cause)

    public constructor(message: String):super(message)

}