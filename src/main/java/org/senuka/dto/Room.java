package org.senuka.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Room {
    private Long id;
    private User owner;
    private List<Participant> participants;
}
