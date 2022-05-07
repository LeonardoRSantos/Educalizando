package com.br.educaoqualidade.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Endereco {

    @Id
    private Long id;
    private String numero;
    private String cidade;
    private String uf;
    private String cep;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<@NotEmpty Aluno> alunos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<@NotEmpty Instituicao> instituicaos = new LinkedHashSet<>();


}
