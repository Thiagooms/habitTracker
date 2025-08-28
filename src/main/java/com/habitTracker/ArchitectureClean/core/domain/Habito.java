package com.habitTracker.ArchitectureClean.core.domain;

import com.habitTracker.ArchitectureClean.core.enums.Frequencia;

import java.util.Objects;

public class Habito {
    private final Long id;
    private String titulo;
    private String descricao;
    private Frequencia frequencia;
    private final Long pessoaId;

    public Habito(Long id, String titulo, String descricao, Frequencia frequencia, Long pessoaId){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.frequencia = frequencia;
        this.pessoaId = pessoaId;
    }

    public Long getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDescricao(){
        return descricao;
    }

    public Frequencia getFrequencia(){
        return frequencia;
    }

    public Long getPessoaId(){
        return pessoaId;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setFrequencia(Frequencia frequencia){
        this.frequencia = frequencia;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(this == null || getClass() != o.getClass()) return false;
        Habito habito = (Habito) o;
        return Objects.equals(id, habito.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Habito{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", frequencia=" + frequencia +
                ", pessoaId=" + pessoaId +
                '}';
    }
}
