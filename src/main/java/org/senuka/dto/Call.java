package org.senuka.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Call {
    private Long id;
    private Room room;
    private SdpDescription offer;
    private SdpDescription answer;
    private List<IceCandidate> offerCandidates;
    private List<IceCandidate> answerCandidates;
}
