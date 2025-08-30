package com.habitTracker.ArchitectureClean.core.usecases;

import com.habitTracker.ArchitectureClean.core.domain.Pessoa;
import com.habitTracker.ArchitectureClean.core.gateway.IPessoaGateway;

public class CriarPessoaUseCase {

    private final IPessoaGateway pessoaGateway;

    public CriarPessoaUseCase(IPessoaGateway pessoaGateway){
        this.pessoaGateway = pessoaGateway;
    }

    public Output execute(Input input){
        Pessoa novaPessoa = new Pessoa(null, input.nome());

        Pessoa pessoaSalva = this.pessoaGateway.salvar(novaPessoa);

        return new Output(pessoaSalva);
    }

    public record Input(
            String nome
    ){}

    public record Output(
            Pessoa pessoa
    ) {}

}
