
package com.ust.Capstone2.WebController;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SurveyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showWelcomePageReturnsOk() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void showSurveyPageReturnsOk() throws Exception {
        this.mockMvc.perform(get("/survey")).andExpect(status().isOk());

    }

    @Test
    public void showThankyouPageReturnsOk() throws Exception {
        this.mockMvc.perform(get("/thankyou")).andExpect(status().isOk());
    }

    @Test
    public void showResultPageReturnsOk() throws Exception {
        this.mockMvc.perform(get("/result")).andExpect(status().isOk());

    }
}






