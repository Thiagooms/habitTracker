package com.habitTracker.ArchitectureClean.infra.presentation;

import com.habitTracker.ArchitectureClean.core.usecases.CriarNovoHabitoUseCase;
import com.habitTracker.ArchitectureClean.core.usecases.ListarHabitosPessoaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habitos")
public class HabitoController {

    private final CriarNovoHabitoUseCase criarNovoHabitoUseCase;
    private final ListarHabitosPessoaUseCase listarHabitosPessoaUseCase;

    public HabitoController(CriarNovoHabitoUseCase criarNovoHabitoUseCase,
                            ListarHabitosPessoaUseCase listarHabitosPessoaUseCase) {
        this.criarNovoHabitoUseCase = criarNovoHabitoUseCase;
        this.listarHabitosPessoaUseCase = listarHabitosPessoaUseCase;
    }

    @PostMapping
    public ResponseEntity<CriarNovoHabitoUseCase.Output> criarHabito
            (@RequestBody CriarNovoHabitoUseCase.Input input) {

        CriarNovoHabitoUseCase.Output output = criarNovoHabitoUseCase.execute(input);

        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

    @GetMapping("/por-pessoa/{pessoaId}")
    public ResponseEntity<ListarHabitosPessoaUseCase.Output> listarHabitos
            (@PathVariable Long pessoaId) {

        ListarHabitosPessoaUseCase.Input input = new ListarHabitosPessoaUseCase.Input(pessoaId);
        ListarHabitosPessoaUseCase.Output output = listarHabitosPessoaUseCase.execute(input);

        return ResponseEntity.ok(output);

    }
}
