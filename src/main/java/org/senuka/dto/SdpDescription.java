package org.senuka.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.senuka.util.CandidateDescriptionType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SdpDescription {
    private Long id;

    private String type;

    private String sdp;
}
