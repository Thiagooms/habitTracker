package com.habitTracker.ArchitectureClean.infra.persistence.mapper;

import com.habitTracker.ArchitectureClean.core.domain.Habito;
import com.habitTracker.ArchitectureClean.infra.persistence.repository.entity.HabitoJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class HabitoMapper {

    public HabitoJpaEntity toJpaEntity(Habito domainObj){
        HabitoJpaEntity entity = new HabitoJpaEntity();
        entity.setId(domainObj.getId());
        entity.setTitulo(domainObj.getTitulo());
        entity.setDescricao(domainObj.getDescricao());
        entity.setFrequencia(domainObj.getFrequencia());
        entity.setPessoaId(domainObj.getPessoaId());
        return entity;
    }

    public Habito toDomain(HabitoJpaEntity entity){
        return new Habito(
                entity.getId(),
                entity.getTitulo(),
                entity.getDescricao(),
                entity.getFrequencia(),
                entity.getPessoaId()
        );
    }
}
