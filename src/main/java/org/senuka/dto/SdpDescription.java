package org.senuka.dto;

import lombok.Builder;
import lombok.Data;
import org.senuka.util.SdpDescriptionType;

@Data
@Builder
public class SdpDescription {
    private Long id;
    private SdpDescriptionType type;
    private Object sdp;
}
