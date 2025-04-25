package org.senuka.dto;

import lombok.Data;

@Data
public class ChatMessage {
    private String sender;
    private String senderGuestName;
    private String message;
}
