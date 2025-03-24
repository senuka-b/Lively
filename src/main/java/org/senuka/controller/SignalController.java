package org.senuka.controller;

import lombok.RequiredArgsConstructor;
import org.senuka.dto.IceCandidate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class SignalController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/signal/ice-candidate/")
    public IceCandidate receiveCandidate(@Payload IceCandidate candidate) {

        // TODO: Save to database

        simpMessagingTemplate.convertAndSend(String.format("/topic/%s/new-candidate", candidate.getCall().getId()), candidate);

        return candidate;
    }





}
