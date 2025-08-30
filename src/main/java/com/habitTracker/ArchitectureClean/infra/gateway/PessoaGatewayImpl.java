package com.habitTracker.ArchitectureClean.infra.gateway;

import com.habitTracker.ArchitectureClean.core.domain.Pessoa;
import com.habitTracker.ArchitectureClean.core.gateway.IPessoaGateway;
import com.habitTracker.ArchitectureClean.infra.persistence.mapper.PessoaMapper;
import com.habitTracker.ArchitectureClean.infra.persistence.repository.IPessoaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PessoaGatewayImpl implements IPessoaGateway {

    private final IPessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaGatewayImpl(IPessoaRepository pessoaRepository, PessoaMapper pessoaMapper){
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        var pessoaEntity = pessoaMapper.toJpaEntity(pessoa);
        var pessoaSalvaEntity = pessoaRepository.save(pessoaEntity);
        return pessoaMapper.toDomain(pessoaSalvaEntity);
    }

    @Override
    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.findById(id).map(pessoaMapper::toDomain);
    }

    @Override
    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id){
        pessoaRepository.deleteById(id);
    }

}
