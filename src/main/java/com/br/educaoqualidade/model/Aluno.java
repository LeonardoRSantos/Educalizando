package com.br.educaoqualidade.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Aluno")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobnrenome;
    private String matricula;
    private String email;
    private String cpf;
    private String contato;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<@NotEmpty Endereco> enderecos = new LinkedHashSet<>();

    private Float notaEnem;
    private Float notaProva;

    @OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<@NotEmpty Instituicao> instituicaos = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobnrenome() {
        return sobnrenome;
    }

    public void setSobnrenome(String sobnrenome) {
        this.sobnrenome = sobnrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Float getNotaEnem() {
        return notaEnem;
    }

    public void setNotaEnem(Float notaEnem) {
        this.notaEnem = notaEnem;
    }

    public Float getNotaProva() {
        return notaProva;
    }

    public void setNotaProva(Float notaProva) {
        this.notaProva = notaProva;
    }

    public Set<Instituicao> getInstituicaos() {
        return instituicaos;
    }

    public void setInstituicaos(Set<Instituicao> instituicaos) {
        this.instituicaos = instituicaos;
    }
}
