package com.habitTracker.ArchitectureClean.infra.persistence.mapper;

import com.habitTracker.ArchitectureClean.core.domain.Pessoa;
import com.habitTracker.ArchitectureClean.infra.persistence.repository.entity.PessoaJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public PessoaJpaEntity toJpaEntity(Pessoa domainObj) {
        if(domainObj == null) return null;

        PessoaJpaEntity entity = new PessoaJpaEntity();
        entity.setId(domainObj.getId());
        entity.setNome(domainObj.getNome());
        return entity;
    }

    public Pessoa toDomain(PessoaJpaEntity entity) {
        if (entity == null) return null;

        return new Pessoa(
                entity.getId(),
                entity.getNome()
        );
    }

}
