package org.senuka.controller;

import lombok.RequiredArgsConstructor;
import org.senuka.dto.IceCandidate;
import org.senuka.dto.JoinRequest;
import org.senuka.dto.SdpDescription;
import org.senuka.dto.Stream;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequiredArgsConstructor
public class SignalController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/stream/{streamCode}/ice-candidate/{viewer}")
    public void handleICECandidate(@DestinationVariable String streamCode,
                                   @DestinationVariable String viewer,
                                   @Payload IceCandidate candidate) {

        System.out.println("Received ICE candidate for stream: " + streamCode + " from viewer: " + viewer);
        System.out.println("Candidate: " + candidate);

        simpMessagingTemplate.convertAndSend("/topic/stream/" + streamCode + "/ice-candidate/" + viewer, candidate);

    }

    @MessageMapping("/stream/{streamCode}/sdp/{viewer}")
    public void handleSDP(@DestinationVariable String streamCode,
                                   @DestinationVariable String viewer,
                                   @Payload SdpDescription sdp) {

        System.out.println("Received SDP for stream: " + streamCode + " from viewer: " + viewer);
        System.out.println("SDP: " + sdp.getType());

        simpMessagingTemplate.convertAndSend("/topic/stream/" + streamCode + "/sdp/" + viewer, sdp);

    }

    @MessageMapping("/stream/join")
    public void join(@Payload JoinRequest joinRequest) {

        System.out.println("Received join request: " + joinRequest + " " +  joinRequest.getUniqueID());

        simpMessagingTemplate.convertAndSend(String.format("/topic/stream/%s/new-join", joinRequest.getStreamCode()), joinRequest.getUniqueID());


    }





}
