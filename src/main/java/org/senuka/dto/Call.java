package org.senuka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Call {
    private Long id;
    private Stream stream;
    private SdpDescription offer;
    private SdpDescription answer;
    private List<IceCandidate> offerCandidates;
    private List<IceCandidate> answerCandidates;
}
