package com.ms.email_service.controllers;

import com.ms.email_service.application.EmailSenderService;
import com.ms.email_service.core.EmailRequest;
import com.ms.email_service.core.exceptions.EmailServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            emailSenderService.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("Email sent successfully!");
        } catch (EmailServiceException ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
