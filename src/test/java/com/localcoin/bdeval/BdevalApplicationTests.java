package com.localcoin.bdeval;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = BdevalApplication.class
)
@AutoConfigureMockMvc
class BdevalApplicationTests
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    void findRangeInfoVOsTest() throws Exception
    {
        String expectedJson ="[\n" +
                "    {\n" +
                "        \"atm\": \"ATM1\",\n" +
                "        \"ranges\": [\n" +
                "            {\n" +
                "                \"start_date\": \"2019-03-10\",\n" +
                "                \"end_date\": \"2019-04-23\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"start_date\": \"2019-04-26\",\n" +
                "                \"end_date\": \"2019-05-17\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"atm\": \"ATM2\",\n" +
                "        \"ranges\": [\n" +
                "            {\n" +
                "                \"start_date\": \"2019-02-20\",\n" +
                "                \"end_date\": \"2019-03-13\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"start_date\": \"2019-05-10\",\n" +
                "                \"end_date\": \"2019-05-16\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"start_date\": \"2019-05-20\",\n" +
                "                \"end_date\": \"2019-05-23\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

        MockHttpServletRequestBuilder requestBuilder = get("/api/v1/search_ranges");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

}
