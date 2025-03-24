package org.senuka.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "calls")
@Data
public class CallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "offer_sdp_id")
    private SdpDescriptionEntity offer;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "answer_sdp_id")
    private SdpDescriptionEntity answer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IceCandidateEntity> offerCandidates;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IceCandidateEntity> answerCandidates;

}
