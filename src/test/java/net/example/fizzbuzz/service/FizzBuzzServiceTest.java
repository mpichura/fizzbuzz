package net.example.fizzbuzz.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzServiceTest {

    private FizzBuzzService objectUnderTest = new FizzBuzzService();

    @Test
    void shouldProperlyTestStep1() {
        final String result = objectUnderTest.step1FizzBuzz(1, 20);
        assertEquals("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz", result);
    }

    @Test
    void shouldFailTestStep1() {
        assertThrows(IllegalArgumentException.class, () -> {objectUnderTest.step1FizzBuzz(1, 0);});
    }

    @Test
    void shouldProperlyTestStep2() {
        final String result = objectUnderTest.step2FizzBuzz(1, 20);
        assertEquals("1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz", result);
    }

    @Test
    void shouldFailTestStep2() {
        assertThrows(IllegalArgumentException.class, () -> {objectUnderTest.step2FizzBuzz(1, 0);});
    }

    @Test
    void shouldProperlyTestStep3() {
        final String result = objectUnderTest.step3FizzBuzz(1, 20);
        assertEquals("1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz\n" +
                "fizz: 4 buzz: 3 fizzbuzz: 1 alfresco: 2 integer: 10", result);
    }

    @Test
    void shouldFailTestStep3() {
        assertThrows(IllegalArgumentException.class, () -> {objectUnderTest.step3FizzBuzz(1, 0);});
    }


}