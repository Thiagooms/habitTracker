package com.habitTracker.ArchitectureClean.core.domain;

import java.time.LocalTime;
import java.util.Objects;

public class Rotina {
    private final Long id;
    private String nome;
    private LocalTime horario;
    private final Long pessoaId;

    public Rotina(Long id, String nome, LocalTime horario, Long pessoaId){
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.pessoaId = pessoaId;
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public LocalTime horario(){
        return horario;
    }

    public Long getPessoaId(){
        return pessoaId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rotina rotina = (Rotina) o;
        return Objects.equals(id, rotina.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
