package org.senuka.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import org.senuka.util.SdpDescriptionType;

@Data
@Builder
public class SdpDescription {
    private Long id;

    @Enumerated(EnumType.STRING)
    private SdpDescriptionType type;

    private String sdp;
}
