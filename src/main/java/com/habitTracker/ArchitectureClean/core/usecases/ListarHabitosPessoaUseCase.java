package com.habitTracker.ArchitectureClean.core.usecases;

import com.habitTracker.ArchitectureClean.core.domain.Habito;
import com.habitTracker.ArchitectureClean.core.gateway.IHabitoGateway;
import java.util.List;

public class ListarHabitosPessoaUseCase {

    private final IHabitoGateway habitoGateway;

    public ListarHabitosPessoaUseCase(IHabitoGateway habitoGateway){
        this.habitoGateway = habitoGateway;
    }

    public Output execute(Input input){
        List<Habito> habitoDaPessoa = this.habitoGateway.buscarTodosPorPessoaId(input.pessoaId());

        return new Output(habitoDaPessoa);
    }

    public record Input(
            Long pessoaId
    ) {}

    public record Output(
            List<Habito> habitos
    ) {}

}
