package com.habitTracker.ArchitectureClean.core.gateway;

import com.habitTracker.ArchitectureClean.core.domain.Pessoa;
import java.util.Optional;

public interface IPessoaGateway {

    Pessoa salvar(Pessoa pessoa);
    Optional<Pessoa> buscarPorId(Long id);
    void deletarPorId(Long id);

}