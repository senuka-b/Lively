package org.senuka.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import org.senuka.util.IceCandidateType;

@Data
@Builder
public class IceCandidate {
    private Long id;
    private String candidateData;

    @Enumerated(EnumType.STRING)
    private IceCandidateType type;

    private Call call;
}
