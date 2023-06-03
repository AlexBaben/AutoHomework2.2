package ru.netology.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {
    @Test
    void shouldGetCardDelivery() {
        Configuration.headless = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Казань");
        $("[data-test-id='name'] .input__control").setValue("Александр");
        $("[data-test-id='phone'] .input__control").setValue("+79200000000");
        $("[data-test-id='agreement']").click();
        $(withText("Забронировать")).click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofMillis(13000));
    }
}


