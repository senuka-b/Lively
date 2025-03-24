package org.senuka.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IceCandidate {
    private Long id;
    private Object candidateData;
}
