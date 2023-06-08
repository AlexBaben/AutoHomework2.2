package ru.netology.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.BACK_SPACE;
import static org.openqa.selenium.Keys.DELETE;

class RegistrationTest {
    @Test
    void shouldGetCardDelivery() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Казань");
        $(".calendar-input input").click();
        $(".calendar-input input").sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        $(".calendar-input input").setValue(LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        $("[data-test-id='name'] .input__control").setValue("Александр");
        $("[data-test-id='phone'] .input__control").setValue("+79200000000");
        $("[data-test-id='agreement']").click();
        $(withText("Забронировать")).click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofMillis(13000));
    }
}


