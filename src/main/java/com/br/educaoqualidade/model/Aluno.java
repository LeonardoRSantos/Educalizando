package com.br.educaoqualidade.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private String sobrenome;

    private String matricula;
    @Email
    private String email;
    @CPF
    private String cpf;

    private String contato;


    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<@NotEmpty Endereco> enderecos = new LinkedHashSet<>();

    private Float notaEnem;
    private Float notaProva;
    //provalmente se tiver erro, vai ser por o motivo de instituição ser abstract e não poder ser instanciado.
//    @OneToMany(mappedBy = "Instituicao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<@NotEmpty Instituicao> instituicaos = new LinkedHashSet<>();

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "comprovacaoRenda")
    @MapsId
    private ComprovacaoRenda comprovacaoRenda;

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
        return sobrenome;
    }

    public void setSobnrenome(String sobnrenome) {
        this.sobrenome = sobnrenome;
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

//    public Set<Instituicao> getInstituicaos() {
//        return instituicaos;
//    }
//
//    public void setInstituicaos(Set<Instituicao> instituicaos) {
//        this.instituicaos = instituicaos;
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
        result = prime * result + ((contato == null) ? 0 : contato.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (contato == null) {
            if (other.contato != null)
                return false;
        } else if (!contato.equals(other.contato))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (sobrenome == null) {
            if (other.sobrenome != null)
                return false;
        } else if (!sobrenome.equals(other.cpf))
            return false;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.cpf))
            return false;
        return true;
    }



}
