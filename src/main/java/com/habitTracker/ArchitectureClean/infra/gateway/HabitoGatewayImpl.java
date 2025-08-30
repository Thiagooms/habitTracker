package com.habitTracker.ArchitectureClean.infra.gateway;

import com.habitTracker.ArchitectureClean.core.domain.Habito;
import com.habitTracker.ArchitectureClean.core.gateway.IHabitoGateway;
import com.habitTracker.ArchitectureClean.infra.persistence.HabitoJpaEntity;
import com.habitTracker.ArchitectureClean.infra.persistence.mapper.HabitoMapper;
import com.habitTracker.ArchitectureClean.infra.persistence.repository.IHabitoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class HabitoGatewayImpl implements IHabitoGateway {

    private final IHabitoRepository habitoRepository;
    private final HabitoMapper habitoMapper;

    public HabitoGatewayImpl(IHabitoRepository habitoRepository, HabitoMapper habitoMapper){
        this.habitoRepository = habitoRepository;
        this.habitoMapper = habitoMapper;
    }

    @Override
    public Habito salvar(Habito habito){
        HabitoJpaEntity entityParaSalvar = habitoMapper.toJpaEntity(habito);
        HabitoJpaEntity entitySalva = habitoRepository.save(entityParaSalvar);
        return habitoMapper.toDomain(entitySalva);
    }

    @Override
    public Optional<Habito> buscarPorId(Long id){
        return habitoRepository.findById(id)
                .map(habitoMapper::toDomain);
    }

    @Override
    public List<Habito> buscarTodosPorPessoaId(Long pessoaId){
        return habitoRepository.findByPessoaId(pessoaId)
                .stream()
                .map(habitoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id){
        habitoRepository.deleteById(id);
    }
}
