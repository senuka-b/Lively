package org.senuka.repository;

import org.senuka.entity.CallEntity;
import org.senuka.entity.StreamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CallRepository extends JpaRepository<CallEntity, Long> {
    List<CallEntity> findAllByRoom(StreamEntity room);
}
