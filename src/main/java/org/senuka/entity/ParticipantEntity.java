package org.senuka.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "participant")
@Data
public class ParticipantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;
}
