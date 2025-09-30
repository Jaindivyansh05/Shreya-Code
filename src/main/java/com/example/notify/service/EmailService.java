package com.example.notify.service;

import com.example.notify.dto.EmailRequest;

public interface EmailService {
    void sendEmailAsync(EmailRequest request);
}