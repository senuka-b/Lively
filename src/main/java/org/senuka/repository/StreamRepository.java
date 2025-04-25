package org.senuka.repository;

import org.senuka.entity.StreamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StreamRepository extends JpaRepository<StreamEntity, Long> {
    Boolean existsByCode(String code);
    Optional<StreamEntity> findByCode(String code);
}
