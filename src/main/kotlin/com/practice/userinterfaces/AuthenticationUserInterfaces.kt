package com.practice.userinterfaces

import io.appium.java_client.MobileBy
import net.serenitybdd.screenplay.targets.Target

class AuthenticationUserInterfaces {

    companion object {
        @JvmStatic
        var TEXTFIELD_USER: Target = Target.the("Campo de texto de usuario")
                .located(MobileBy.AccessibilityId("test-Username"))

        @JvmStatic
        var TEXTFIELD_PASSWORD: Target = Target.the("Campo de texto de contraseña")
                .located(MobileBy.AccessibilityId("test-Password"))

        @JvmStatic
        var BUTTON_LOGIN: Target = Target.the("Botón para hacer login")
                .located(MobileBy.AccessibilityId("test-LOGIN"))

        @JvmStatic
        var LABEL_PRODUCTS: Target = Target.the("Etiqueta de titulo Productos")
                .located(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"))

        @JvmStatic
        var ALERT_MESSAGE_ERROR: Target = Target.the("Mensaje error en alerta")
                .located(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"))
    }

}