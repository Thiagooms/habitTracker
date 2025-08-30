package com.habitTracker.ArchitectureClean.infra.persistence.repository;

import com.habitTracker.ArchitectureClean.infra.persistence.repository.entity.PessoaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPessoaRepository extends JpaRepository<PessoaJpaEntity, Long> {

}
