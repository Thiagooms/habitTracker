package com.habitTracker.ArchitectureClean.infra.presentation;

import com.habitTracker.ArchitectureClean.core.usecases.CriarNovoHabitoUseCase;
import com.habitTracker.ArchitectureClean.core.usecases.CriarPessoaUseCase;
import com.habitTracker.ArchitectureClean.core.usecases.ListarPessoasUseCase;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pessoas")
public class PessoaController {

    private final CriarPessoaUseCase criarPessoaUseCase;
    private final ListarPessoasUseCase listarPessoasUseCase;

    public PessoaController(CriarPessoaUseCase criarPessoaUseCase, ListarPessoasUseCase listarPessoasUseCase){
        this.criarPessoaUseCase = criarPessoaUseCase;
        this.listarPessoasUseCase = listarPessoasUseCase;
    }

    @PostMapping
    public ResponseEntity<CriarPessoaUseCase.Output> criarPessoa(
            @RequestBody CriarPessoaUseCase.Input input
    ) {
        CriarPessoaUseCase.Output output = criarPessoaUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

    @GetMapping
    public ResponseEntity<ListarPessoasUseCase.Output> listarPessoas() {
        ListarPessoasUseCase.Input input = new ListarPessoasUseCase.Input();
        ListarPessoasUseCase.Output output = listarPessoasUseCase.execute(input);
        return ResponseEntity.ok(output);
    }
}
