package com.habitTracker.ArchitectureClean.core.gateway;

import com.habitTracker.ArchitectureClean.core.domain.Habito;

import java.util.List;
import java.util.Optional;

public interface IHabitoGateway {
    Habito salvar(Habito habito);
    Optional<Habito> buscarPorId(Long id);
    List<Habito> buscarTodosPorPessoaId(Long pessoaId);
    void deletarPorId(Long id);
}
