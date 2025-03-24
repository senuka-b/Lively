package org.senuka.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.senuka.util.SdpDescriptionType;

@Entity
@Table(name = "sdp_description")
@Data
public class SdpDescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SdpDescriptionType type;
    private String sdp;

}
