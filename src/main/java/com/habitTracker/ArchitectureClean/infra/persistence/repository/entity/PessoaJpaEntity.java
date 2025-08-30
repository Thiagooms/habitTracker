package com.habitTracker.ArchitectureClean.infra.persistence.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas")
public class PessoaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public PessoaJpaEntity() {}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

}
