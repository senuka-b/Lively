package org.senuka.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.senuka.dto.Participant;

import java.util.List;

@Entity
@Table(name = "room")
@Data
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;

    private String code;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParticipantEntity> participants;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private CallEntity room;


}
