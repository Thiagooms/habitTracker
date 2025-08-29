package com.habitTracker.ArchitectureClean.core.usecases;

import com.habitTracker.ArchitectureClean.core.domain.Habito;
import com.habitTracker.ArchitectureClean.core.enums.Frequencia;
import com.habitTracker.ArchitectureClean.core.gateway.IHabitoGateway;

public class CriarNovoHabitoUseCase {

    private final IHabitoGateway habitoGateway;
    private Input input;

    public CriarNovoHabitoUseCase(IHabitoGateway habitoGateway) {
        this.habitoGateway = habitoGateway;
    }

    public Output execute(Input input) {
        this.input = input;
        Habito novoHabito = new Habito(
                null,
                input.titulo(),
                input.descricao(),
                input.frequencia(),
                input.pessoaId()
        );

        Habito habitoSalvo = this.habitoGateway.salvar(novoHabito);

        return new Output(habitoSalvo);
    }

    public record Input(
            Long pessoaId,
            String titulo,
            String descricao,
            Frequencia frequencia
    ) {}

    public record Output(
            Habito habito
    ) {}
}
