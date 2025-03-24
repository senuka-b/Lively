package org.senuka.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Participant {
    private Long id;
    private String username;
    private String colorCode;
}
