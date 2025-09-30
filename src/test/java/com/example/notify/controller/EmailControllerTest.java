package com.example.notify.controller;

import com.example.notify.dto.EmailRequest;
import com.example.notify.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = EmailController.class)
class EmailControllerTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;

    @MockBean private EmailService emailService;

    @Test
    void sendEmail_returns202_andCallsService() throws Exception {
        Mockito.doNothing().when(emailService).sendEmailAsync(any());

        EmailRequest req = new EmailRequest();
        req.setTo("a@b.com");
        req.setSubject("Hi");
        req.setBody("Hello");

        mockMvc.perform(post("/api/notifications/send-email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
               .andExpect(status().isAccepted())
               .andExpect(content().string("Email request accepted"));

        Mockito.verify(emailService).sendEmailAsync(any(EmailRequest.class));
    }

    @Test
    void sendEmail_validatesInput() throws Exception {
        mockMvc.perform(post("/api/notifications/send-email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
               .andExpect(status().isBadRequest());
    }
}