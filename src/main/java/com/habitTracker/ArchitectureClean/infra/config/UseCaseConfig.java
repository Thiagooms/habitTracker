package com.habitTracker.ArchitectureClean.infra.config;

import com.habitTracker.ArchitectureClean.core.gateway.IHabitoGateway;
import com.habitTracker.ArchitectureClean.core.gateway.IPessoaGateway;
import com.habitTracker.ArchitectureClean.core.usecases.CriarNovoHabitoUseCase;
import com.habitTracker.ArchitectureClean.core.usecases.CriarPessoaUseCase;
import com.habitTracker.ArchitectureClean.core.usecases.ListarHabitosPessoaUseCase;
import com.habitTracker.ArchitectureClean.core.usecases.ListarPessoasUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CriarPessoaUseCase criarPessoaUseCase(IPessoaGateway pessoaGateway) {
        return new CriarPessoaUseCase(pessoaGateway);
    }

    @Bean
    public ListarPessoasUseCase listarPessoasUseCase(IPessoaGateway pessoaGateway) {
        return new ListarPessoasUseCase(pessoaGateway);
    }

    @Bean
    public CriarNovoHabitoUseCase criarNovoHabitoUseCase(IHabitoGateway habitoGateway) {
        return new CriarNovoHabitoUseCase(habitoGateway);
    }

    @Bean
    public ListarHabitosPessoaUseCase listarHabitosPessoaUseCase(IHabitoGateway habitoGateway) {
        return new ListarHabitosPessoaUseCase(habitoGateway);
    }

}
