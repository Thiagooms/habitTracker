package com.habitTracker.ArchitectureClean.core.usecases;

import com.habitTracker.ArchitectureClean.core.domain.Pessoa;
import com.habitTracker.ArchitectureClean.core.gateway.IPessoaGateway;

import java.util.List;

public class ListarPessoasUseCase {

    private final IPessoaGateway pessoaGateway;

    public ListarPessoasUseCase(IPessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    public Output execute(Input input){
        List<Pessoa> todasAsPessoas = this.pessoaGateway.buscarTodos();

        return new Output(todasAsPessoas);
    }

    public record Input(){}

    public record Output(
            List<Pessoa> pessoas
    ){}
}
