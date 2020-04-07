package com.example.reglas;

import io.cucumber.java8.En;
import com.example.services.PicoPlacaService;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PicoPlacaSteps implements En {
    private PicoPlacaService picoPlacaCalculator;

    public PicoPlacaSteps() {
        Given("a checker initialized", () -> {
            picoPlacaCalculator = new PicoPlacaService();
        });

        When("I check {string} and {string}", (final String dateTime, final String plate) -> {
            picoPlacaCalculator.checkPermission(dateTime, plate);
        });

        Then("the result is {string}",
                (final String expected) -> assertEquals(expected, picoPlacaCalculator.getResult()));

    }

}
