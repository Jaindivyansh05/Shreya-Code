package com.example.notify.service;

import com.example.notify.dto.EmailRequest;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class EmailServiceImplTest {

    @Test
    void sendEmailAsync_buildsAndSendsMessage() {
        JavaMailSender mailSender = mock(JavaMailSender.class);
        EmailServiceImpl service = new EmailServiceImpl(mailSender);

        EmailRequest r = new EmailRequest();
        r.setTo("x@y.com");
        r.setSubject("Sub");
        r.setBody("Body");

        service.sendEmailAsync(r);

        ArgumentCaptor<SimpleMailMessage> captor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mailSender, timeout(500)).send(captor.capture());

        SimpleMailMessage msg = captor.getValue();
        assertThat(msg.getTo()).containsExactly("x@y.com");
        assertThat(msg.getSubject()).isEqualTo("Sub");
        assertThat(msg.getText()).isEqualTo("Body");
    }
}