package org.senuka.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ice_candidate")
@Data
public class IceCandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateData;

    @ManyToOne
    @JoinColumn(name = "call_id")
    private CallEntity call;

}
