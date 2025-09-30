package com.example.notify.controller;

import com.example.notify.dto.EmailRequest;
import com.example.notify.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@Valid @RequestBody EmailRequest request) {
        emailService.sendEmailAsync(request);
        return ResponseEntity.accepted().body("Email request accepted");
    }
}