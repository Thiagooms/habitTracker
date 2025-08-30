package com.habitTracker.ArchitectureClean.infra.persistence.repository;

import com.habitTracker.ArchitectureClean.infra.persistence.HabitoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHabitoRepository extends JpaRepository<HabitoJpaEntity, Long> {
    List<HabitoJpaEntity> findByPessoaId(Long pessoaId);
}
