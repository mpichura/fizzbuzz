package net.example.fizzbuzz.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static net.example.fizzbuzz.controller.FizzBuzzController.FIZZBUZZ_RESOURCE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenProperParamsPassed_thenExpectProperFizzBuzzResult() throws Exception {

        final MvcResult mvcResult = mockMvc.perform(get(FIZZBUZZ_RESOURCE)
                .param("startFrom", "1")
                .param("endAt", "20")
        )
                .andExpect(status().isOk())
                .andReturn();

        final String result = mvcResult.getResponse().getContentAsString();
        assertEquals("1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz\n" +
                "fizz: 4 buzz: 3 fizzbuzz: 1 alfresco: 2 integer: 10", result);
    }

    @Test
    void whenNotProperParamsPassed_thenExpect4xx() throws Exception {

        final MvcResult mvcResult = mockMvc.perform(get(FIZZBUZZ_RESOURCE)
                .param("startFrom", "1")
                .param("endAt", "0")
        )
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

    @Test
    void whenNotStringParamsPassed_thenExpect4xx() throws Exception {

        final MvcResult mvcResult = mockMvc.perform(get(FIZZBUZZ_RESOURCE)
                .param("startFrom", "b")
                .param("endAt", "b")
        )
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

}
